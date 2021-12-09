package com.example.myapplication;

public class DanhSach {
    private int id,sdt;
    private String ten,email;

    public DanhSach(int id, int sdt, String ten, String email) {
        this.id = id;
        this.sdt = sdt;
        this.ten = ten;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
