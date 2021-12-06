package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemDanhSach extends AppCompatActivity {

    SQLiteDatabase db;
    Button btnXoa, btnLuu, btnDong;
    EditText edtName, edtTell, edtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themdanhba);
        Wigets();
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText("");
                edtTell.setText("");
                edtAddress.setText("");
            }
        });
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemDanhSach.this, MainActivity.class);
                startActivity(intent);

            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().isEmpty()){
                    Toast.makeText(getApplication(), "Thông tin không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                themDanhSach();
            }

            private void themDanhSach() {
                String fullName, tell, address;
                fullName = edtName.getText().toString();
                tell = edtTell.getText().toString();
                address = edtAddress.getText().toString();
                ContentValues values = new ContentValues();
                values.put("name", fullName);
                values.put("tell", tell);
                values.put("address", address);

                try{
                    db = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);
                    long id = db.insert(MainActivity.TABLE_NAME,null, values);
                    Toast.makeText(getApplication(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Toast.makeText(getApplication(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    public void Wigets() {
        btnLuu = (Button) findViewById(R.id.btnThemMoi);
        btnXoa = (Button) findViewById(R.id.btnXoaTrang);
        btnDong = (Button) findViewById(R.id.btnQuayLai);
        edtName = (EditText) findViewById(R.id.edten);
        edtTell = (EditText) findViewById(R.id.edsdt);
        edtAddress = (EditText) findViewById(R.id.edmail);
    }
}