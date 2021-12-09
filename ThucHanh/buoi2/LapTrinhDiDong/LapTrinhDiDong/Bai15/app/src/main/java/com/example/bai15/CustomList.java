package com.example.bai15;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String> {
    private  Activity context;
    private  String[] lstItem;
    ArrayList<Integer> imageId = new ArrayList<>();
    public CustomList(Activity context, String[] lstItem) {
        super(context, R.layout.list_single, lstItem);
        this.context = context;
        this.lstItem = lstItem;
        setImage();
    }
    private void setImage(){
        int n = lstItem.length;
        for(int i = 0; i < n; i++){
            if(lstItem[i].length()  <= 3){
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
        txtTitle.setText(lstItem[position]);

        imageView.setImageResource((int)imageId.get(position));
        return rowView;
    }
}
