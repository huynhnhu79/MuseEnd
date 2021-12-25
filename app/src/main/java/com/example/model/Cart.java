package com.example.model;

public class Cart  {
    private int cId;
    private  String CName;
    private double wPrice;
    private byte[] wThumb;



    public Cart(int cId, String CName, double wPrice, byte[] wThumb){
        this.cId = cId;
        this.CName = CName;
        this.wPrice = wPrice;
        this.wThumb = wThumb;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public double getwPrice() {
        return wPrice;
    }

    public void setwPrice(double wPrice) {
        this.wPrice = wPrice;
    }

    public byte[] getwThumb() {
        return wThumb;
    }

    public void setwThumb(byte[] wThumb) {
        this.wThumb = wThumb;
    }

}
