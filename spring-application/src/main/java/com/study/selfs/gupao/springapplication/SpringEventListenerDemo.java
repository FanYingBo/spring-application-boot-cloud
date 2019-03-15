package com.study.selfs.gupao.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

public class SpringEventListenerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.addApplicationListener(new MyContextClosedEventListener());
        context.refresh();

        context.publishEvent(new ApplicationEvent("hello world") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        context.publishEvent(new MyEvent("hello event"));
        context.close();
    }
   public static class MyEvent extends ApplicationEvent {

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

class MyContextClosedEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听事件："+event);
    }
}

class MyContextRefresheventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("监听上下文刷新事件："+event);
    }
}



