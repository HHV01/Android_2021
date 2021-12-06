package com.example.kiemtragiuaky_spinner;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends ArrayAdapter {
    private Activity context;
    ArrayList<String> lstNguoiDep = new ArrayList<>();
    int[] lstImage;

    public CustomAdapter(Activity context,ArrayList<String> lst, int[] images ) {
        super(context, android.R.layout.simple_dropdown_item_1line, lst);
        this.context = context;
        lstImage = images;
        lstNguoiDep = lst;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View x = inflater.inflate(R.layout.haucung_spinner_layout, null, true);
        TextView txtView = (TextView) x.findViewById(R.id.textView);
        ImageView imageView = (ImageView) x.findViewById(R.id.imageView);

        txtView.setText(lstNguoiDep.get(position));
        imageView.setImageResource((int)lstImage[position]);
/*        if(position == 1){
            txtTitle.setBackgroundColor(Color.rgb(128, 0, 128));
            txtTitle.setTextColor(Color.WHITE);
        }*/
        return x;
    }
}
