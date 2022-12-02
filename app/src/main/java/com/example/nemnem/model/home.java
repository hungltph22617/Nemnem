package com.example.nemnem.model;

public class home {
    private int hinh;
    private String tieude, noidung;

    public home(int hinh, String tieude, String noidung) {
        this.hinh = hinh;
        this.tieude = tieude;
        this.noidung = noidung;
    }

    public home() {
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
