package com.example.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int Id;
    private String Ten;
    private double Gia;

    public SanPham(int id, String ten, double gia) {
        Id = id;
        Ten = ten;
        Gia = gia;
    }

    public SanPham() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    @Override
    public String toString() {
        return this.Ten+"\n"+this.Gia+"\n"+this.Id;
    }
}
