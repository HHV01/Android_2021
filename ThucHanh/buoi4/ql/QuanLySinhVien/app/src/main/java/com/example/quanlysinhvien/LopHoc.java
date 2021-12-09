package com.example.quanlysinhvien;

public class LopHoc {
    private int id_class;
    private String  name_class;
    private int siso;

    public LopHoc(int id_class, String name_class, int siso) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.siso = siso;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }



    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public int getSiso() {
        return siso;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }
}
