package com.example.quanlysinhvien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<SinhVien> {
    private Activity context;
    private ArrayList<SinhVien> lst;
    public CustomAdapter(Activity context, int textViewResourceId, @NonNull ArrayList<SinhVien> objects) {
        super(context, textViewResourceId, objects);
        this.lst = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list_sv_layout, null, true);
        TextView txtMaSV = (TextView) rowView.findViewById(R.id.txtMSSV);
        TextView txtTenSV = (TextView) rowView.findViewById(R.id.txtHoTen);
        TextView txtLop = (TextView) rowView.findViewById(R.id.txtLop);


        txtMaSV.setText(lst.get(position).getId());
        txtTenSV.setText(lst.get(position).getHoten());
        txtLop.setText(lst.get(position).getTenLop());
        return rowView;
    }

}
