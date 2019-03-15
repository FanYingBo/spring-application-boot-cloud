package com.study.selfs.gupao.springcloud.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.study.selfs.gupao.springcloud.test.LoadBalanceDemo.roundRobinBalance;

/**
 * 负载均衡三种实现方式
 * 1.随机负载
 * 2.轮询
 * 3.权重轮询
 *
 */
public class LoadBalanceDemo {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        Server[] serversArr = {new Server("server-1").setWeight(3),new Server("server-2").setWeight(2)};
        List<Server> servers = Arrays.asList(serversArr);
        WeightRoundRobin weightRounngRobin = new WeightRoundRobin(servers);
        for(int i = 0;i < 10;i ++){
            Thread thread = new Thread("thread-"+i) {
                @Override
                public void run() {
                    Server server = weightRounngRobin.getServer();
                    System.out.println("thread: "+currentThread().getName()+" server: "+server.getServerName());
                }
            };
            thread.start();
        }
//        System.out.println(5%3);

    }
    //随机
    public static Server randomBalance(List<Server> collection){
        Server server = null;
        if(collection != null){
            int index = new Random().nextInt(collection.size());
            server = collection.get(index);
        }
        return server;
    }
    // 轮询
    public static Server roundRobinBalance( List<Server> collection){
        if(atomicInteger.get()> collection.size()-1){
            atomicInteger = new AtomicInteger();
        }
        return collection.get(atomicInteger.getAndIncrement());
    }

}

class Server{

    private int weight;

    private String serverName;

    public Server(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public Server setServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }


    public int getWeight() {
        return weight;
    }

    public Server setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
class RequestThread extends Thread{

    private List<Server> servers;

    public RequestThread(String name, List<Server> servers){
        super(name);
        this.servers = servers;
    }
    @Override
    public void run() {
        // 随机
//        Server server = randomBalance(servers);
        Server server = roundRobinBalance(servers);
        System.out.println("thread: "+currentThread().getName()+" server: "+server.getServerName());
    }
}

// 权重轮询算法
class WeightRoundRobin{

    /**上次选择的服务器*/
    private int currentIndex = -1;
    /**当前调度的权值*/
    private int currentWeight = 0;
    /**最大权重*/
    private int maxWeight = -1;
    /**权重的最大公约数*/
    private int gcdWeight;
    /**服务器数*/
    private int serverCount;
    private List<Server> servers;


    public WeightRoundRobin(List<Server> servers) {
        this.servers = (servers == null ? new ArrayList<>():new ArrayList<>(servers));
        this.serverCount = servers.size();
        greatestCommonDivisor(); //得到集合所有权重的最大公约数
    }


    private int calcGreaterCommonDivisor(int server1,int server2){
        if(server1 % server2 == 0){
            return  server2;
        }else{
            return calcGreaterCommonDivisor(server2,server1 % server2);
        }
    }

    /*
     * 得到list中所有权重的最大公约数，实际上是两两取最大公约数d，然后得到的d
     * 与下一个权重取最大公约数，直至遍历完
     * 并拿到最大权重
     */
    private void greatestCommonDivisor() {
        for (int index = 0, len = servers.size(); index < len - 1; index++) {
            if (index == 0) {
                gcdWeight = calcGreaterCommonDivisor(
                        servers.get(index).getWeight(), servers.get(index + 1).getWeight());
            } else {
                gcdWeight = calcGreaterCommonDivisor(gcdWeight, servers.get(index).getWeight());
            }
            if(servers.get(index).getWeight() > maxWeight){
                maxWeight = servers.get(index).getWeight();
            }
        }
    }

    public Server getServer(){
        List<Server> serverSnap = this.servers;
        while(true){
            currentIndex = (currentIndex + 1) % serverCount;
//            System.out.println("thread: "+Thread.currentThread().getName()+" currentIndex: "+currentIndex+" currentWeight: "+currentWeight);
            if(currentIndex == 0){
                currentWeight = currentWeight - gcdWeight;
                if(currentWeight <= 0){
                    currentWeight = maxWeight;
                    if(currentWeight == 0){
                        return null;
                    }
                }
            }
            if(serverSnap.get(currentIndex).getWeight() >= currentWeight){
                return serverSnap.get(currentIndex);
            }
        }
    }
}

