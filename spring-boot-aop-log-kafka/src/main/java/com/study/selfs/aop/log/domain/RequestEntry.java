package com.study.selfs.aop.log.domain;

import java.util.Map;
import java.util.HashMap;

public class RequestEntry {

    private String address;

    private String uri;

    private Map<String,Object> parameters;


    public String getAddress() {
        return address;
    }

    public RequestEntry setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public RequestEntry setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public RequestEntry setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }
}
