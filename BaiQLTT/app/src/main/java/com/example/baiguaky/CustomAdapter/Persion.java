package com.example.baiguaky.CustomAdapter;

import java.io.Serializable;

public class Persion implements Serializable {
    private String ten;
    private String sdt;
    private String diachi;
    private String queQuan;
    private int  id;

    public String getQueQuan() {
        return queQuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persion(String ten, String sdt, String diachi, String queQuan) {
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.queQuan = queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Persion() {
    }
}
