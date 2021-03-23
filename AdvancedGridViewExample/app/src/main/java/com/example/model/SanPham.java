package com.example.model;

import java.io.Serializable;

public class SanPham {
    private int hinh;
    private String ten;

    public SanPham() {
    }

    public SanPham(int hinh, String ten) {
        this.hinh = hinh;
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
