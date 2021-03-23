package com.example.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String TenSP;
    private String MauSac;

    public SanPham(String tenSP, String mauSac) {
        TenSP = tenSP;
        MauSac = mauSac;
    }

    public SanPham() {
    }

    @Override
    public String toString() {
        return this.TenSP+"\n"+this.MauSac;
    }

    public String getTenSP() {
        return TenSP;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public void setMauSac(String mauSac) {
        MauSac = mauSac;
    }
}
