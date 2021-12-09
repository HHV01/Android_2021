package com.example.bai17;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterBaiHat extends ArrayAdapter<BaiHat> {
    ArrayList<BaiHat> lstBH;
    Activity context;
    public CustomAdapterBaiHat(Activity context, @NonNull ArrayList<BaiHat> lstBH) {
        super(context,R.layout.single_baihat_layout, lstBH);
        this.context =  context;
        this.lstBH = lstBH;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_baihat_layout, null, true);
        TextView txtSTTBH = (TextView) rowView.findViewById(R.id.txtSTTBH);
        TextView txtTenBH = (TextView) rowView.findViewById(R.id.txtTenBH);
        TextView txtNgay = (TextView) rowView.findViewById(R.id.txtNgay);
        int stt = position + 1;
        txtSTTBH.setText(stt+ "");
        txtTenBH.setText(lstBH.get(position).getTenBaiHat());
        txtNgay.setText(lstBH.get(position).getNgayTao().toString());

        return rowView;
    }
}
