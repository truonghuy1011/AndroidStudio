package com.example.model;



import java.io.Serializable;

public class SanPham implements Serializable {
    private int Hinh;
    private String SanPham;
    private int Gia;

    public SanPham(int hinh, String sanPham, int gia) {
        Hinh = hinh;
        SanPham = sanPham;
        Gia = gia;
    }

    public SanPham() {
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getSanPham() {
        return SanPham;
    }

    public void setSanPham(String sanPham) {
        SanPham = sanPham;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "Hinh=" + Hinh +
                ", SanPham='" + SanPham + '\'' +
                ", Gia=" + Gia +
                '}';
    }
}
