package com.example.nemnem.model;

public class SanPhamBanChay {
    private String tensp;
    private int soLuong;
    public static final String TB_NAME = "SanPhamBanChay";
    public static final String COL_NAMESP = "tensp";
    public static final String COL_SOLUONG = "soLuong";

    public SanPhamBanChay() {
    }

    public SanPhamBanChay(String tensp, int soLuong) {
        this.tensp = tensp;
        this.soLuong = soLuong;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
