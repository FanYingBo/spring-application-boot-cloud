package com.study.selfs.gupao.springcloud.zookeeper.client.cache;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class TargetInstanceCache {

    private Set<String> urls = new HashSet<>();

    public TargetInstanceCache(Set<String> urls){
        this.urls = urls;
    }

    public void setUrls(Set<String> urls){
        this.urls = urls;
    }

    public Set<String> getUrls(){
        return this.urls;
    }
}
