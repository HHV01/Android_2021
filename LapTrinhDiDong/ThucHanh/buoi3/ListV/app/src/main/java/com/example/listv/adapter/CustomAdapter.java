package com.example.listv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listv.R;
import com.example.listv.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private ArrayList<Contact> arrContact;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrContact = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        TextView tvSTT = (TextView) convertView.findViewById(R.id.tv1);
        TextView tvMa = (TextView) convertView.findViewById(R.id.tv2);
        TextView tvTen = (TextView) convertView.findViewById(R.id.tv3);
        Contact contact = arrContact.get(position);
        tvSTT.setText((position+1)+"");
        tvMa.setText(contact.getmMa());
        tvTen.setText(contact.getmTen());
        return convertView;
    }
}
