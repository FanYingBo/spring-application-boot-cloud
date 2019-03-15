package com.study.selfs.gupao.custom.springboot.starter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(CustomConfig.class)
@EnableConfigurationProperties(CustomConfigProperties.class)
public class CustomConfigAutoConfiguration {

    @Autowired
    private CustomConfigProperties customConfigProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "custom" ,value = "enable", havingValue = "true")
    public CustomConfig customConfig(){
        return new CustomConfig(customConfigProperties.getConfig());
    }

}
