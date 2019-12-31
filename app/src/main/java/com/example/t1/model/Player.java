package com.example.t1.model;

import androidx.annotation.Nullable;

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

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj)
            return true;
        Player player = (Player) obj;
        if(name.compareTo(player.name) == 0
                && value.compareTo(player.value) == 0){
            return true;
        }
        return false;
    }
}
