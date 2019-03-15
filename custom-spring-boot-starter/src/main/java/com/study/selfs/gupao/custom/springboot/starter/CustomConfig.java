package com.study.selfs.gupao.custom.springboot.starter;



public class CustomConfig {

    private String config;

    public CustomConfig(String config) {
        this.config = config;
    }

    public String getConfig(){
        return this.config;
    }
}
