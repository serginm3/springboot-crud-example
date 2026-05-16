package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cat {

    public Cat() {
    }


    @Id
    private Long id;

    private String name;

    private String picUrl;

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
