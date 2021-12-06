package com.example.quanlysinhvien;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapterLopHoc extends ArrayAdapter<LopHoc> {
    ArrayList<LopHoc> lst;
    Activity context;
    public CustomAdapterLopHoc(Activity context, int textViewResourceId, ArrayList<LopHoc> objects) {
        super(context, textViewResourceId, objects);
        this.lst = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list_lophoc_layout, null, true);
        TextView txtMaLop = (TextView) rowView.findViewById(R.id.txtMaLopLV);
        TextView txtTenLop = (TextView) rowView.findViewById(R.id.txtTenLopLV);
        TextView txtSiSo = (TextView) rowView.findViewById(R.id.txtSiSo);


        txtMaLop.setText(lst.get(position).getId_class() + "");
        txtTenLop.setText(lst.get(position).getName_class() + "");
        txtSiSo.setText(lst.get(position).getSiso() + "");
        return rowView;
    }


}
