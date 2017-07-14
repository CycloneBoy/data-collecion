package com.cycloneboy.domain;

/**
 * Created by CycloneBoy on 2017/7/14.
 */
public class Demo {
    private Long id;
    private String name;

    public Demo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
