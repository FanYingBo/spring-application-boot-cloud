package com.study.selfs.gupao.springboot.jdbc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.management.MXBean;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfigration {

    /**
     * spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
     * spring.datasource.url=jdbc:mysql://192.168.8.156:3306/devlopment?useSSL=false&serverTimezone=UTC&characterEncoding=utf8&allowMultiQueries=true
     * spring.datasource.username=root
     * spring.datasource.password=root123
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource masterDataSource(){
        /*DataSource build = dataSourceBuilder
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://192.168.1.156:3306/devlopment?useSSL=false&serverTimezone=UTC&characterEncoding=utf8&allowMultiQueries=true")
                .username("root")
                .password("root123")
                .build();*/
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource slaveDataSource(){
       /* DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        DataSource build = dataSourceBuilder
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://192.168.1.156:3306/study?useSSL=false&serverTimezone=UTC&characterEncoding=utf8&allowMultiQueries=true")
                .username("root")
                .password("root123")
                .build();*/
        return  DataSourceBuilder.create().build();
    }


}
