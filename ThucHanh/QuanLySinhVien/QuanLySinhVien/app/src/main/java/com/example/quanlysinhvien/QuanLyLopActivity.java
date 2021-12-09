package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuanLyLopActivity extends AppCompatActivity {
    ListView lv;
    Button btnThem;
    ArrayList<LopHoc> lstLopHoc;
    SQLiteDatabase db;
    CustomAdapterLopHoc adaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_lop);
        db = openOrCreateDatabase(Login.DATABASE_NAME, MODE_PRIVATE, null);
        lv = (ListView) findViewById(R.id.lvLopHoc);
        btnThem = (Button) findViewById(R.id.btnThemLopWTF);
        lstLopHoc = getListLopHoc();
        adaper = new CustomAdapterLopHoc(QuanLyLopActivity.this, R.layout.custom_list_lophoc_layout, lstLopHoc);
        lv.setAdapter(adaper);
        btnThem = (Button) findViewById(R.id.btnThemLopWTF);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(QuanLyLopActivity.this, ThemLopHocActivity.class);
            startActivity(intent);
            }
        });
    }
    private ArrayList<LopHoc> getListLopHoc(){
        ArrayList<LopHoc> lstLopHoc = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from tbclass", null);
        if(cursor.moveToFirst()){
            do{
                int id_class = Integer.parseInt(cursor.getString(0));
                String name_class = cursor.getString(2);
                int siso = Integer.parseInt(cursor.getString(3));
                LopHoc lh = new LopHoc(id_class, name_class, siso);
                lstLopHoc.add(lh);

            }while(cursor.moveToNext());
        }

        return lstLopHoc;
    }
}