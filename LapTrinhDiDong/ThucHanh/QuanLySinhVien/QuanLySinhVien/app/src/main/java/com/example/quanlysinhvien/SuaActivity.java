package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class SuaActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText edtMaSV, edtTenSV, edtNgaySinh;
    RadioGroup rdbGioiTinh;
    Spinner spinner;
    Button btnCapNhat;
    int id = 0, vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        db = openOrCreateDatabase(Login.DATABASE_NAME, MODE_PRIVATE, null);
        getWiget();
        getClassID();
        Intent intent = getIntent();
        id =  Integer.parseInt( intent.getStringExtra("id") );
        Toast.makeText(getApplication(), id + "", Toast.LENGTH_SHORT).show();
        String query = "select * from tbstudent where id_student = ?";
        Cursor cursor = db.rawQuery(query, new String[]{id + ""});
        if(cursor.moveToFirst()){
            String maSV;
            String tenSV;
            String ngaySinh;
            String gioiTinh;
            int maLop;
            do{
                maLop = Integer.parseInt(cursor.getString(1) );
                maSV = cursor.getString(2);
                tenSV = cursor.getString(3);
                gioiTinh = cursor.getString(4);
                ngaySinh = cursor.getString(5);
            }while(cursor.moveToNext());
            edtMaSV.setText(maSV);
            edtNgaySinh.setText(ngaySinh);
            edtTenSV.setText(tenSV);
            rdbGioiTinh.setSelected(true);
        }
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String maSV = edtMaSV.getText().toString();
                String tenSV = edtTenSV.getText().toString();
                String ngaySinh = edtNgaySinh.getText().toString();
                String gioiTinh = ((RadioButton)findViewById(rdbGioiTinh.getCheckedRadioButtonId())).getText().toString();
                String tenLop = spinner.getSelectedItem().toString();
                Cursor cursor1 = db.rawQuery("select id_class from tbclass where  name_class= ?", new String[] {tenLop});
                int maLop = 0;
                if(cursor1.moveToFirst()){
                    do{
                        maLop = Integer.parseInt(cursor1.getString(0));
                    }while(cursor1.moveToNext());

                }

                ContentValues values = new ContentValues();
                values.put("id_class", maLop);
                values.put("code_student", maSV);
                values.put("name_student", tenSV);
                values.put("gender_student", gioiTinh);
                values.put("birthday_student", ngaySinh);
                try{
                    String selection = "id_student =" + id;
                    int count = db.update("tbstudent", values, selection,null);
                    Toast.makeText(getApplication(), count + "", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(SuaActivity.this, QuanLySinhVienActivity.class);
                    startActivity(intent2);
                }catch (Exception ex){
                    Toast.makeText(getApplication(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
    private void getWiget(){
        edtMaSV = (EditText) findViewById(R.id.edtEditStudentCode);
        edtTenSV = (EditText) findViewById(R.id.edtEditStudentName);
        edtNgaySinh = (EditText) findViewById(R.id.edtEditStudentBirthday);
        rdbGioiTinh = (RadioGroup) findViewById(R.id.rdigroupEditGender);
        spinner = (Spinner) findViewById(R.id.spnEditClassCode);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);

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
            ArrayAdapter<String> adapter = new ArrayAdapter<>(SuaActivity.this, R.layout.support_simple_spinner_dropdown_item, classID);
            adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
            spinner.setAdapter(adapter);
            Intent intent = getIntent();
            String class_name = intent.getStringExtra("class_name");

            for(int i = 0; i < classID.size(); i++){
                if(classID.get(i).equals(class_name) ){
                    vitri = i;
                    break;
                }
            }

            spinner.setSelection(vitri);
        } catch (Exception ex){
            Toast.makeText(getApplication(), classID.size() + "Quen bai", Toast.LENGTH_LONG).show();
        }



    }
}