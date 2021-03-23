package com.example.model;

import java.io.Serializable;

public class sanpham implements Serializable {
    private int ID;
    private String Name;

    public sanpham(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public sanpham() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return this.ID+"/n"+this.Name;
    }
}
