package com.example.quanlysinhvien;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThemSinhVienActivity extends AppCompatActivity {
    Spinner spinner;
    EditText edtMaSV, edtTenSV, edtNgaySinh;
    RadioGroup rdbGioiTinh;
    SQLiteDatabase db;
    Button btnThem, btnXoa, btnDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        getWidget();
        getClassID();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = edtMaSV.getText().toString();
                String tenSV = edtTenSV.getText().toString();
                String ngaySinh = edtNgaySinh.getText().toString();
                String gioiTinh = ((RadioButton)findViewById(rdbGioiTinh.getCheckedRadioButtonId())).getText().toString();
                String TenLop = spinner.getSelectedItem().toString();
                Cursor cursor = db.rawQuery("select id_class from tbclass where name_class = ?", new String[] {TenLop});
                int id_class = 0;
                if(cursor.moveToFirst()){
                    do{
                        id_class = Integer.parseInt( cursor.getString(0));
                    }while (cursor.moveToNext());
                }



                ContentValues values = new ContentValues();
                values.put("id_class", id_class);
                values.put("code_student", maSV);
                values.put("name_student", tenSV);
                values.put("gender_student", gioiTinh);
                values.put("birthday_student", ngaySinh);
                try{
                    long id = db.insert("tbstudent",null, values);
                    Intent intent = new Intent(ThemSinhVienActivity.this, QuanLySinhVienActivity.class);
                    startActivity(intent);
                }catch (Exception ex){
                    Toast.makeText(getApplication(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private void getWidget(){
        spinner = (Spinner) findViewById(R.id.spnEditClassCode_Them);
        edtMaSV = (EditText) findViewById(R.id.edtEditStudentCode_Them);
        edtTenSV = (EditText) findViewById(R.id.edtEditStudentName_Them);
        edtNgaySinh = (EditText) findViewById(R.id.edtEditStudentBirthday_Them);
        rdbGioiTinh = (RadioGroup) findViewById(R.id.rdigroupEditGender_Them);
        btnThem = (Button)  findViewById(R.id.btn_Them);
    }

    private void getClassID(){
        db = openOrCreateDatabase(Login.DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select name_class from tbclass", null);
        ArrayList<String> classID = new ArrayList<>();

        try {
            if(cursor.moveToFirst()){
                do{
                    classID.add(cursor.getString(0));
                }while(cursor.moveToNext());
            }
        } catch (Exception ex){
            Toast.makeText(getApplication(), "Lai sai", Toast.LENGTH_LONG).show();
        }


        try{
            ArrayAdapter<String> adapter = new ArrayAdapter<>(ThemSinhVienActivity.this, R.layout.support_simple_spinner_dropdown_item, classID);
            adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
            spinner.setAdapter(adapter);
        } catch (Exception ex){
            Toast.makeText(getApplication(), classID.size() + "Quen bai", Toast.LENGTH_LONG).show();
        }



    }
}