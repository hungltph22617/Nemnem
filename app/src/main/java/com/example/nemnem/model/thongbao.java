package com.example.nemnem.model;

public class thongbao {
    private int anh;
    private String tbtd;

    public thongbao(int anh, String tbtd) {
        this.anh = anh;
        this.tbtd = tbtd;
    }

    public thongbao() {
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTbtd() {
        return tbtd;
    }

    public void setTbtd(String tbtd) {
        this.tbtd = tbtd;
    }
}
