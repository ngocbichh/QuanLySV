package com.example.quanlysinhviensqlite.model;

public class SinhVienLop {
    private int id;
    private int idSV;
    private int idLop;
    private String kyHoc;
    private int soTC;

    public SinhVienLop() {
    }

    public SinhVienLop(int id, int idSV, int idLop, String kyHoc, int soTC) {
        this.id = id;
        this.idSV = idSV;
        this.idLop = idLop;
        this.kyHoc = kyHoc;
        this.soTC = soTC;
    }

    public SinhVienLop(int idSV, int idLop, String kyHoc, int soTC) {
        this.idSV = idSV;
        this.idLop = idLop;
        this.kyHoc = kyHoc;
        this.soTC = soTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public String toString(){
        return "ID: " +getId()+
                "Ky hoc: "+getKyHoc()+
                "So tin chi: "+getSoTC();
    }
}
