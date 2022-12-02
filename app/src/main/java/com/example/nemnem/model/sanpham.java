package com.example.nemnem.model;

public class sanpham {
    private int masp;
    private String tensp;
    private int soluong;
    private int dongia;

    public sanpham(int masp, String tensp, int soluong, int dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public sanpham(String tensp, int soluong, int dongia) {
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public sanpham() {
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
