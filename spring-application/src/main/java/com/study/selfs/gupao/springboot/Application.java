package com.study.selfs.gupao.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	    //
	    SpringApplication springApplication = new SpringApplication(Application.class);
        Properties properties = new Properties();
        properties.setProperty("server.port","0");

        springApplication.addListeners(event -> {
            System.out.println("事件："+event.getClass().getName());
        });
        springApplication.setDefaultProperties(properties);
	    // 设置为非web应用
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        // 获得应用上下文
        ConfigurableApplicationContext context =
                springApplication.run(args);
        System.out.println(context);
        context.close();


    }
}
