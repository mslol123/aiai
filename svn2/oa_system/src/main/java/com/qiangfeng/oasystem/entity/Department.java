package com.qiangfeng.oasystem.entity;

public class Department implements java.io.Serializable{
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return name ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
