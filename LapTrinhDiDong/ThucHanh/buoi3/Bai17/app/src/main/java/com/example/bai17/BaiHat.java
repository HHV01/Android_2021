package com.example.bai17;

import java.util.Date;

public class BaiHat {
    private String tenBaiHat;
    private String ngayTao;

    public BaiHat(String tenBaiHat, String ngayTao) {
        this.tenBaiHat = tenBaiHat;
        this.ngayTao = ngayTao;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
