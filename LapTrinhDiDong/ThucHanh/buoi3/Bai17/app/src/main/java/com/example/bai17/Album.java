package com.example.bai17;

import java.util.ArrayList;

public class Album {
    private String maAlbum;
    private String tenAlbum;
    ArrayList<BaiHat> lstBaiHat;

    public Album(String maAlbum, String tenAlbum, ArrayList<BaiHat> lstBaiHat) {
        this.maAlbum = maAlbum;
        this.tenAlbum = tenAlbum;
        this.lstBaiHat = lstBaiHat;
    }

    public Album(String maAlbum, String tenAlbum) {
        this.maAlbum = maAlbum;
        this.tenAlbum = tenAlbum;
    }

    public String getMaAlbum() {
        return maAlbum;
    }

    public void setMaAlbum(String maAlbum) {
        this.maAlbum = maAlbum;
    }

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }

    public ArrayList<BaiHat> getLstBaiHat() {
        return lstBaiHat;
    }

    public void setLstBaiHat(ArrayList<BaiHat> lstBaiHat) {
        this.lstBaiHat = lstBaiHat;
    }
}
