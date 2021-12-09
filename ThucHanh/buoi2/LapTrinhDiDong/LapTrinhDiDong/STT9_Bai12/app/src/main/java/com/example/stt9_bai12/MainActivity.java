package com.example.stt9_bai12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    ArrayList<String> lstName= new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView)findViewById(R.id.simpleListView);
        lstName.add("Vân");
        lstName.add("Thái");
        lstName.add("Tuấn");
        lstName.add("Thành");
        lstName.add("Duy");
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.txtTest, lstName);
        simpleList.setAdapter(arrayAdapter);
        Button btnNhap = (Button) findViewById(R.id.btnNhap);
        btnNhap.setOnClickListener(addToListView);
        simpleList.setOnItemClickListener(selectItemOnListView);
    }
    private OnItemClickListener selectItemOnListView = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            TextView textView = (TextView) findViewById(R.id.txtInfo);
            textView.setText(lstName.get(i).toString());
        }
    };


    private OnClickListener addToListView = new OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView info = (TextView) findViewById(R.id.edtTen);
            String s = info.getText().toString();
            if(s.isEmpty()){
                return;
            }
            lstName.add(s);
            info.setText("");
            onResume();

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        arrayAdapter.notifyDataSetChanged();
    }
}