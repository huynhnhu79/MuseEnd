package com.example.model;

public class DanhMucSanPham {
    private int productThumbSP;
    private String productNameSP;
    private double productPriceSP;
    private String productDetailSP;

    public DanhMucSanPham(int productThumbSP, String productNameSP, double productPriceSP, String productDetailSP) {
        this.productThumbSP = productThumbSP;
        this.productNameSP = productNameSP;
        this.productPriceSP = productPriceSP;
        this.productDetailSP = productDetailSP;

    }



    public int getProductThumbSP() {
        return productThumbSP;
    }

    public void setProductThumbSP(int productThumbSP) {
        this.productThumbSP = productThumbSP;
    }

    public String getProductNameSP() {
        return productNameSP;
    }

    public void setProductNameSP(String productNameSP) {
        this.productNameSP = productNameSP;
    }

    public double getProductPriceSP() {
        return productPriceSP;
    }

    public void setProductPriceSP(double productPriceSP) {
        this.productPriceSP = productPriceSP;
    }

    public String getProductDetailSPSP() {
        return productDetailSP;
    }

    public void setProductDetailSP(String productDetailSP) {
        this.productDetailSP = productDetailSP;
    }



}
