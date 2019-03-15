package com.study.selfs.gupao.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.lang.reflect.AnnotatedElement;

/**
 *
 * 上下文事件机制实例
 */
public class SimpleApplicationEventMulticasterDemo {

    public static void main(String[] args) {

//        AnnotatedElement annotatedElement = SimpleApplicationEventMulticasterDemo.class;
        ApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();

        simpleApplicationEventMulticaster.addApplicationListener(event -> {
            System.out.println("触发事件："+event);
        });

        simpleApplicationEventMulticaster.multicastEvent(new MyEvent("hello world"));
        simpleApplicationEventMulticaster.multicastEvent(new PayloadApplicationEvent<>("1","wwds"));
    }

    static class MyEvent extends ApplicationEvent{

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyEvent(Object source) {
            super(source);
        }
    }
}

