package com.study.selfs.gupao.springboot.jdbc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfigration {

    @Bean
    @Primary
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
