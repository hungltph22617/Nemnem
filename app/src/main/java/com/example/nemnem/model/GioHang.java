package com.example.nemnem.model;

public class GioHang {
    private int masp;
    private String tensp;
    private int soluong;
    private int dongia;

    public GioHang() {
    }

    public static final String TB_NAME = "Giohang";
    public static final String COL_ID = "masp";
    public static final String COL_NAME = "tensp";
    public static final String COL_NUM = "soluong";
    public static final String COL_PRICE = "dongia";

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}
