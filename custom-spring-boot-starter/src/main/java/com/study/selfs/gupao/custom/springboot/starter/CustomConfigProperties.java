package com.study.selfs.gupao.custom.springboot.starter;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("custom")
public class CustomConfigProperties {

    private boolean enable;

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
