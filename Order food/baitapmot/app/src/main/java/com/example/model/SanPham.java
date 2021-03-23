package com.example.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class SanPham implements Serializable {
    private  String Mausac;
    private String tenSP;
    public SanPham() {
    }
    public SanPham(String tenSP, String mausac) {
        this.tenSP = tenSP;
        Mausac = mausac;
    }
    public SanPham(String mausac) {
        Mausac = mausac;
    }
    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public String getMausac() {
        return Mausac;
    }
    public void setMausac(String mausac) {
        Mausac = mausac;
    }
    @NonNull
    @Override
    public String toString() {
        return  this.tenSP + "\n" + this.Mausac;
    }


}
