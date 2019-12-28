package com.example.t1.model;

public class Player {

    public String name;
    public String value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public boolean isEmpty(){
        return value == null || value.compareTo("")==0;
    }

}
