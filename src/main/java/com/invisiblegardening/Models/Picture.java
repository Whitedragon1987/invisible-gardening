package com.invisiblegardening.Models;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String type;

    @Lob
    byte[] data;

    @OneToOne(mappedBy = "picture")
    Machine machine;

    @OneToOne(mappedBy = "picture")
    Job job;

    public Picture(){
    };

    public Picture(String name, String type, byte[] data) {

        this.name = name;

        this.type = type;

        this.data = data;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

