package com.example.listv.model;

public class Contact {
    private String mMa;
    private String mTen;

    public Contact( String mMa, String mTen) {
        this.mMa = mMa;
        this.mTen = mTen;
    }


    public String getmMa() {
        return mMa;
    }

    public void setmMa(String mMa) {
        this.mMa = mMa;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }
}
