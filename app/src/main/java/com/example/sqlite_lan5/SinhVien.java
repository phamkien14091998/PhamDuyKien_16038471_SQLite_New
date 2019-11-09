package com.example.sqlite_lan5;

public class SinhVien {
    private int id;
    private int mssv;
    private String tenSV;

    public SinhVien(int id, int mssv, String tenSV) {
        this.id = id;
        this.mssv = mssv;
        this.tenSV = tenSV;
    }

    public SinhVien(int mssv, String tenSV) {
        this.mssv = mssv;
        this.tenSV = tenSV;
    }
    public SinhVien() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    @Override
    public String toString() {
        return
                "id:     " + id +
                ", mssv:    " + mssv +
                ", tenSV:    " + tenSV ;
    }
}
