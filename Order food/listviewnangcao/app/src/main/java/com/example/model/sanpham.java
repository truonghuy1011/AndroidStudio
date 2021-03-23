package com.example.model;

import java.io.Serializable;

public class sanpham implements Serializable {
    private int imgId;
    private String ten;
    private double gia;

    public sanpham(int imgId, String ten, double gia) {
        this.imgId = imgId;
        this.ten = ten;
        this.gia = gia;
    }

    public sanpham() {
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }


}

