package com.study.selfs.gupao.custom.springboot;

import com.study.selfs.gupao.custom.springboot.starter.CustomConfig;
import com.study.selfs.gupao.custom.springboot.starter.CustomConfigProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomConfigApplication.class)
public class CustomConfigTestDemo {

    @Autowired
    private CustomConfig customConfig;

    @Test
    public void getCustomConfig(){
        String config = customConfig.getConfig();
        System.out.println(config);
    }

}
