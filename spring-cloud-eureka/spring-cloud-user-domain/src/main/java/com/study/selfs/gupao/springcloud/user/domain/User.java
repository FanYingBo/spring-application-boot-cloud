package com.study.selfs.gupao.springcloud.user.domain;

public class User {

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("User={id=")
                .append(this.id)
                .append(", name=")
                .append(this.name)
                .append("}");
       return sb.toString();
    }
}
