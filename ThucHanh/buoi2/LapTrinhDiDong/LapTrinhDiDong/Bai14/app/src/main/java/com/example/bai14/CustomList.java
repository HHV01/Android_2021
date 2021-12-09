package com.example.bai14;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String> {
    private  Activity context;
    private  String[] lstProvine;
    ArrayList<Integer> imageId = new ArrayList<>();
    public CustomList(Activity context, String[] web) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.lstProvine = web;
        setImage();
    }
    private void setImage(){
        int n = lstProvine.length;
        for(int i = 0; i < n; i++){
            if(lstProvine[i].length()  <= 3){
                imageId.add(R.drawable.ic_star);
            } else{
                imageId.add(R.drawable.ic_cicle);
            }
        }
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(lstProvine[position]);

        imageView.setImageResource(imageId.get(position));
        return rowView;
    }
}
