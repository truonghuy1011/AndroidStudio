package com.example.model;

public class Sach  {
    private int sachID;
    private String sachName;
    private String sachNXB;
    private Double sachPrices;

    public Sach(int sachID, String sachName, String sachNXB, Double sachPrices) {
        this.sachID = sachID;
        this.sachName = sachName;
        this.sachNXB = sachNXB;
        this.sachPrices = sachPrices;
    }

    public Sach() {
    }

    public int getSachID() {
        return sachID;
    }

    public void setSachID(int sachID) {
        this.sachID = sachID;
    }

    public String getSachName() {
        return sachName;
    }

    public void setSachName(String sachName) {
        this.sachName = sachName;
    }

    public String getSachNXB() {
        return sachNXB;
    }

    public void setSachNXB(String sachNXB) {
        this.sachNXB = sachNXB;
    }

    public Double getSachPrices() {
        return sachPrices;
    }

    public void setSachPrices(Double sachPrices) {
        this.sachPrices = sachPrices;
    }

}
