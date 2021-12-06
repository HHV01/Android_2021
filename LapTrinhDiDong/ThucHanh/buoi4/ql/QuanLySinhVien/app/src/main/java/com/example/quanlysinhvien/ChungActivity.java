package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChungActivity extends AppCompatActivity {
    Button btnQLSV, btnQLLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chung);
        btnQLSV =   (Button) findViewById(R.id.btnQlSV);
        btnQLLop =   (Button) findViewById(R.id.btnQLLop);
        btnQLSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChungActivity.this, QuanLySinhVienActivity.class);
                startActivity(intent);
            }
        });
        btnQLLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChungActivity.this, QuanLyLopActivity.class);
                startActivity(intent);
            }
        });

    }
}