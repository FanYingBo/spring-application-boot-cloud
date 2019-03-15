package com.study.selfs.gupao.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 *
 * springapplication application annotation
 */

//@ImportResource(locations = "spring-beans.xml") // 通过xml加载
@Configuration
public class SpringAnnotationApplicationDemo {

    public static void main(String[] args) {

        //xml文件驱动ClassPathXmlApplicationContext
        //annotation 注解驱动

        /**
         * 注解的派生性
         * @Component  org.springframework.stereotype.Component; 元注解
         *
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(SpringAnnotationApplicationDemo.class);
        context.refresh();
        System.out.println(context.getBean(SpringAnnotationApplicationDemo.class));
//        Customer bean = context.getBean(Customer.class);
//        System.out.println(bean);
    }

}
