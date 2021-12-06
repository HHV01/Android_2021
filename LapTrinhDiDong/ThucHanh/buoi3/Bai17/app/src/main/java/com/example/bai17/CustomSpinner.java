package com.example.bai17;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class CustomSpinner extends ArrayAdapter {
    private Activity context;
    private  ArrayList<Album> lst;

    public CustomSpinner(Activity context, ArrayList<Album> lst, ArrayList<String> lstAlbum) {
        super(context, android.R.layout.simple_spinner_item, lstAlbum);
        this.context = context;
        this.lst = lst;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_spinner_layout, null, true);
        TextView txtMaSp = (TextView) rowView.findViewById(R.id.txtMaSp);
        TextView txtTenSp = (TextView) rowView.findViewById(R.id.txtTenSp);

        txtMaSp.setText(lst.get(position).getMaAlbum());
        txtTenSp.setText(lst.get(position).getTenAlbum());
        return rowView;
    }
}
