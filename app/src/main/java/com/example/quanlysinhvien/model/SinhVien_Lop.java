package com.example.quanlysinhvien.model;

public class SinhVien_Lop {
    private int id;
    private SinhVien maSV;
    private Lop maLop;
    private String kyHoc;
    private String soTC;

    public SinhVien_Lop() {
    }

    public SinhVien_Lop(Lop maLop, SinhVien maSV, String kyHoc, String soTC) {
        this.maLop = maLop;
        this.maSV = maSV;
        this.kyHoc = kyHoc;
        this.soTC = soTC;
    }

    public SinhVien getMaSV() {
        return maSV;
    }

    public void setMaSV(SinhVien maSV) {
        this.maSV = maSV;
    }

    public Lop getMaLop() {
        return maLop;
    }

    public void setMaLop(Lop maLop) {
        this.maLop = maLop;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public String getSoTC() {
        return soTC;
    }

    public void setSoTC(String soTC) {
        this.soTC = soTC;
    }
}


