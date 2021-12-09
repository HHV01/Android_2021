package com.example.bai15;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomSpinner extends ArrayAdapter {
    private Activity context;
    private  String[] lstItem;
    ArrayList<Integer> lstImage = new ArrayList<>();

    public CustomSpinner(Activity context, String[] lstSpinner) {
        super(context, android.R.layout.simple_spinner_item, lstSpinner);
        this.context = context;
        lstItem = lstSpinner;
        setImage();
    }
    private void setImage(){
        lstImage.add(R.drawable.phone);
        lstImage.add(R.drawable.maytinh);
        lstImage.add(R.drawable.truyen);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.spinner_layout, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtSpinner);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgSpinner);
        txtTitle.setText(lstItem[position]);
        imageView.setImageResource((int)lstImage.get(position));
        if(position == 1){
            txtTitle.setBackgroundColor(Color.rgb(128, 0, 128));
            txtTitle.setTextColor(Color.WHITE);
        }
        return rowView;
    }
}
