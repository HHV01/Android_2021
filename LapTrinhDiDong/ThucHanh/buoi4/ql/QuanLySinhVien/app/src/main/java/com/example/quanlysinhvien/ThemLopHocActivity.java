package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemLopHocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_them_lop_hoc);
        SQLiteDatabase db = openOrCreateDatabase(Login.DATABASE_NAME, MODE_PRIVATE, null);
        Button btnThem = (Button) findViewById(R.id.btnThemLopHoc);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtMaLop = (EditText) findViewById(R.id.edtMaLop);
                EditText edtTenLop = (EditText) findViewById(R.id.edtTenLop);
                EditText edtSiSo = (EditText) findViewById(R.id.edtSiSo);
                ContentValues values = new ContentValues();
                values.put("code_class", edtMaLop.getText().toString());
                values.put("name_class", edtTenLop.getText().toString());
                values.put("number_student", edtSiSo.getText().toString());
                db.insert("tbclass", null, values);
                Intent intent = new Intent(ThemLopHocActivity.this, QuanLyLopActivity.class);
                startActivity(intent);
            }
        });
    }
}