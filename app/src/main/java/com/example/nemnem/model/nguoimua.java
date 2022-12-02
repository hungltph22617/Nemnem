package com.example.nemnem.model;

public class nguoimua {
    private int ma;
    private String ten;
    private String diachi;
    private int sdt;

    public nguoimua(int ma, String ten, String diachi, int sdt) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public nguoimua(String ten, String diachi, int sdt) {
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public nguoimua() {
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
}
