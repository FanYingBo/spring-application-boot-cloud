package com.study.selfs.gupao.springcloud.zookeeper.server.master;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        System.out.println(hostName);
    }
}
