package com.example.bai3_final;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtA, edtB;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;
    TextView textViewKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addWigets();

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoiA = edtA.getText().toString();
                int soA = Integer.parseInt(chuoiA);
                String chuoiB = edtB.getText().toString();
                int soB = Integer.parseInt(chuoiB);
                int hieu = Math.abs(soA - soB);
                textViewKQ.setText(String.valueOf(hieu));
            }
        });

        btnTich.setOnClickListener(this);
        View.OnClickListener btnClick = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String chuoiA = edtA.getText().toString();
                Float soA = Float.parseFloat(chuoiA);
                String chuoiB = edtB.getText().toString();
                Float soB = Float.parseFloat(chuoiB);

                float thuong = soA / soB;
                textViewKQ.setText(String.valueOf(thuong));
            }
        };
        btnThuong.setOnClickListener(btnClick);
        btnUCLN.setOnClickListener(new MyEvent());
        btnThoat.setOnClickListener(thoat);
    }
    //Add
    public void OnclickInXML(View v){
        String chuoiA = edtA.getText().toString();
        int soA = Integer.parseInt(chuoiA);
        String chuoiB = edtB.getText().toString();
        int soB = Integer.parseInt(chuoiB);
        int tong = soA + soB;
        textViewKQ.setText(String.valueOf(tong));
    }
    //Mutiple
    @Override
    public void onClick(View view) {
        String chuoiA = edtA.getText().toString();
        int soA = Integer.parseInt(chuoiA);
        String chuoiB = edtB.getText().toString();
        int soB = Integer.parseInt(chuoiB);
        int tich = soA * soB;
        textViewKQ.setText(String.valueOf(tich));
    }
    private View.OnClickListener thoat = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
    private void addWigets(){
        edtA = (EditText) findViewById(R.id.editTextA);
        edtB = (EditText) findViewById(R.id.editTextB);
        textViewKQ = (TextView) findViewById(R.id.textViewKetQua);
        btnTong = (Button) findViewById(R.id.buttonTong);
        btnHieu = (Button) findViewById(R.id.buttonTru);
        btnTich = (Button) findViewById(R.id.buttonNhan);
        btnThuong = (Button) findViewById(R.id.buttonChia);
        btnUCLN = (Button) findViewById(R.id.buttonUocChung);
        btnThoat = (Button) findViewById(R.id.buttonThoat);
    }
}