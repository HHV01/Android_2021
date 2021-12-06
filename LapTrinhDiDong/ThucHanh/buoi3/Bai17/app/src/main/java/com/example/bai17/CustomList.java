package com.example.bai17;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Album> {
    ArrayList<Album> lst = new ArrayList<>();
    Activity context;

    public CustomList(@NonNull Context context, ArrayList<Album> lst) {
        super(context, R.layout.single_list_constraint_layout, lst);
        this.lst = lst;
        this.context = (Activity) context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_list_constraint_layout, null, true);
        TextView txtSTT = (TextView) rowView.findViewById(R.id.textSTT);
        TextView txtMa = (TextView) rowView.findViewById(R.id.textMa);
        TextView txtTen = (TextView) rowView.findViewById(R.id.textTen);
        int stt = position + 1;
        txtSTT.setText(stt+ "");
        txtMa.setText(lst.get(position).getMaAlbum().toString());
        txtTen.setText(lst.get(position).getTenAlbum().toString());

        return rowView;
    }

}
