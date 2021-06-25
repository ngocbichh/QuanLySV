package com.example.quanlysinhvien.model;

public class SinhVien {
    private int maSV;
    private String tenSV;
    private int namsinh;
    private String quequan;
    private String namhoc;

    public SinhVien() {
    }

    public SinhVien(int maSV, String tenSV, int namsinh, String quequan, String namhoc) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.namhoc = namhoc;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }
}
