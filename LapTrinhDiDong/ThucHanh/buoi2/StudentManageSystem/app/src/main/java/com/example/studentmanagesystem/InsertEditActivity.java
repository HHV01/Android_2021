package com.example.studentmanagesystem;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagesystem.R;

public class EditActivity extends Activity {
    Button btnSaveClass, btnClearClass, btnCloseClass;
    EditText edtCode, edtName, edtNumber;
    String id_class;
}
    private void initWidget(){
       btnSaveClass = (Button) findViewById(R.id.btnSaveEditClass);
       btnClearClass = (Button) findViewById(R.id.btnClearEditClass);
       btnCloseClass = (Button) findViewById(R.id.btnCloseEditClass);
       edtCode = (EditText) findViewById(R.id.edtEditCLassCode);
       edtName = (EditText) findViewById(R.id.edtEditCLassName);
       edtNumber = (EditText) findViewById(R.id.edtEditCLassNumber);
    }
    private void getData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Room room = (Room) bundle.getSerializable("room");
        id_class = room.getId_class();
        edtCode.setText(room.getCode_class());
        edtName.setText(room.getName_class());
        edtNumber.setText(room.getNumber_class());
    }
    private boolean saveClass(){
        try{
            SQLiteDatabase db = openOrCreateDatabase(Login.DATABASE_NAME, MODE_PRIVATE, null);
            ContentValues values = new ContentValues();
            values.put("code_class", edtCode.getText().toString());
            values.put("name_class", edtName.getText().toString());
            values.put("number_student", Intent.parseIntent(edtNumber.getText().toString());
            if(db.update("tblclass", values,"id_class=?", new String[]{id_class}) != -1)
                return true;
        }
        catch (Exception ex){
            Toast.makeText(getApplication(),"Cập nhập lớp học không thành công", Toast.LENGTH_LONG).show();
        }
        return false;
    }
    private void clearClass(){
        edtCode.setText("");
        edtName.setText("");
        edtNumber.setText("");
    }
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        getData();
        // gắn sự kiện cho btn
        btnSaveClass.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent();
                if(saveClass()){
                    Room r = new Room(id_class,edtCode.getText().toString(), edtName.getText().toString(),edtNumber.getText().toString());
                    bundle.putSerializable("room", r);
                    intent.putExtra("data", bundle);
                    setResult(ClassList.SAVE_CLASS, intent);
                    Toast.makeText(getApplication(),"Cập nhập lớp học thành công",Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
        btnClearClass.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clearClass();
            }
        });
        btnCloseClass.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Notify.exit(EditClassActivity.this);
            }
        });
    }

