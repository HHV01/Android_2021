package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_NAME = "tblContact ";
    SQLiteDatabase db;
    Button btnthem, btndanhsach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
        initDB();
        widget();
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemDanhSach.class);
                startActivity(intent);
            }
        });
        btndanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XemDanhSach.class);
                startActivity(intent);
            }
        });

    }

 void widget() {
        btnthem = (Button) findViewById(R.id.btnThemDanhBa);
        btndanhsach = (Button) findViewById(R.id.btnXemDanhSach);
    }

    public void initDB() {
        db = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
       String query;
       try{

            if( !isTableExist(db, TABLE_NAME)) {
                query = "CREATE TABLE tblContact (IDx INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,";
               query += "name NVARCHAR(500) NOT NULL,";
               query += "tell VARCHAR(500) NOT NULL,";
                query += "email NVARCHAR(500) NOT NULL)";
               db.execSQL(query);

               // Thêm1 hàng dữ liệu vào db

                query = "INSERT INTO tblContact (name, tell, address) VALUES('Nguyên Hữu Vĩnh', '0999999993', 'NguyenHuuVinh')";
               db.execSQL(query);
               Toast.makeText(this, "Insert thanh cong", Toast.LENGTH_LONG).show();

           }

        } catch (Exception ex){
            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        }
   }

   private boolean isTableExist(SQLiteDatabase db, String tableName) {
       String query = "select DISTINCT tbl_name from sqlite_master where tbl_name = '"+ tableName+"'";
        Cursor cursor = db.rawQuery(query, null);
       if(cursor != null){
            return cursor.getCount() > 0;
       }
      return false;
   }
    }
