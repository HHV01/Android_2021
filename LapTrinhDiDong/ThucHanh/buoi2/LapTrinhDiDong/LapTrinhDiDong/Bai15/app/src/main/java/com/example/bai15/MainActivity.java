package com.example.bai15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mobilePhones[]={"Điện thoại" , "May Tinh", "DocSach"};
    String[][] lst = { {"Nokia", "HTC", "IPhone", "SamSung", "HQT"},
            {"Del", "ThinkPad", "Apple", "Lenovo"},
            {"Doraemon", "Shin", "Conan", "HHV"} };
    Spinner spnMobile;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addWigets();
        setSpinner();
        spnMobile.setOnItemSelectedListener(setItem);
    }
    private void addWigets(){
        spnMobile	=	(Spinner) findViewById(R.id.spinner);
        lv = (ListView) findViewById(R.id.list);
    }
    private void setSpinner(){
        CustomSpinner adapter	=	new CustomSpinner(MainActivity.this, mobilePhones);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spnMobile.setAdapter(adapter);
    }

    private OnItemSelectedListener setItem = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
           Toast.makeText(com.example.bai15.MainActivity.this, i + "", Toast.LENGTH_SHORT).show();
           setListView(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    private void setListView(int i){
        CustomList adapter = new CustomList(MainActivity.this, lst[i]);
        lv.setAdapter(adapter);
    }

}