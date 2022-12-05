package com.example.nemnem.model;

public class Lichsu {
    private int masp;
    private String tensp;
    private int dongia;

    public static final String TB_NAME = "Lichsu";
    public static final String COL_ID = "masp";
    public static final String COL_NAME = "tensp";
    public static final String COL_PRICE = "dongia";

    public Lichsu() {
    }

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

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}
