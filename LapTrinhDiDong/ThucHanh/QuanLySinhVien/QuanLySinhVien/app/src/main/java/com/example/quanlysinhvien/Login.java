package com.example.quanlysinhvien;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    public static final String DATABASE_NAME = "student.db";
    SQLiteDatabase db;
    EditText edtUsername, edtPassword;
    Button btnCancel, btnLogin;
    protected  void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername     =   (EditText)  findViewById(R.id.edtUsername);
        edtPassword     =   (EditText)  findViewById(R.id.edtPassword);
        btnLogin        =   (Button)    findViewById(R.id.btnLogin);
        btnCancel       =   (Button)    findViewById(R.id.btnCancel);
        initDB();

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(username.isEmpty()){
                    Toast.makeText(getApplication(), "Tên đăng nhập không được trống", Toast.LENGTH_LONG).show();
                    edtUsername.requestFocus();
                } else if(password.isEmpty()){
                    Toast.makeText(getApplication(), "Mật khẩu không được trống", Toast.LENGTH_LONG).show();
                    edtPassword.requestFocus();
                } else{
                    boolean user = isUser(username, password);
                    if(user){
                        try{
                            Intent intent   =   new Intent(Login.this, ChungActivity.class);
                            startActivity(intent);
                        }
                        catch (Exception ex){
                            Toast.makeText(getApplication(), "Lỗi nữa sao ????!!!", Toast.LENGTH_LONG).show();
                        }

                    } else{
                        Toast.makeText(getApplication(), "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void initDB(){
        db = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        String query;
        try{

            if( !isTableExist(db, "tbuser")) {
                query = "CREATE TABLE tbuser (id_user INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,";
                query += "username VARCHAR(500) NOT NULL,";
                query += "password VARCHAR(500) NOT NULL)";
                db.execSQL(query);
                query = "INSERT INTO tbuser (username, password) VALUES('admin', 'admin')";
                db.execSQL(query);
                Toast.makeText(this, "Try ok", Toast.LENGTH_LONG).show();
            }
            if(!isTableExist(db, "tbclass")) {
                query = "CREATE TABLE tbclass (id_class INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,";
                query += "code_class TEXT NOT NULL,";
                query += "name_class TEXT NOT NULL,";
                query += "number_student INTEGER NOT NULL )";
                db.execSQL(query);
                query = "INSERT INTO tbclass (code_class, name_class, number_student) VALUES('HK1.CQ03)', 'D19PM01', 30)";
                db.execSQL(query);
                query = "INSERT INTO tbclass (code_class, name_class, number_student) VALUES('HK1.CQ0)', 'D19PM02', 25)";
                db.execSQL(query);
            }
            if(!isTableExist(db, "tbstudent")) {
                query = "CREATE TABLE tbstudent (id_student INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,";
                query += "id_class INTEGER NOT NULL,";
                query += "code_student TEXT NOT NULL,";
                query += "name_student TEXT NOT NULL,";
                query += "gender_student TEXT NOT NULL,";
                query += "birthday_student TEXT NOT NULL)";
                db.execSQL(query);
            }

        } catch (Exception ex){
            Toast.makeText(this, "Tạo DB thất bại", Toast.LENGTH_LONG).show();
        }
    }
    //true nếu bảng tồn tại
    private boolean isTableExist(SQLiteDatabase db, String tableName) {
        String query = "select DISTINCT tbl_name from sqlite_master where tbl_name = '"+ tableName+"'";
        Cursor cursor = db.rawQuery(query, null);
       if(cursor != null){
           return cursor.getCount() > 0;
       }

       return false;
    }
    private  boolean isUser(String username, String password){
        try{
            db = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
            String query = "select * from tbuser where username = ? and password = ? ";
            Cursor cursor = db.rawQuery(query,new String[] {username, password});
            //Toast.makeText(this, cursor.getCount() + "", Toast.LENGTH_LONG).show();
            return cursor.getCount() > 0;

        } catch (Exception ex){
            Toast.makeText(this, "Lỗi hàm isUser", Toast.LENGTH_LONG).show();
        }

        return false;
    }

}
