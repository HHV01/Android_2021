package com.example.bai7;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDangNhap, btnThoat;
    CheckBox ckLuu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();

        btnThoat.setOnClickListener(this);
        btnDangNhap.setOnClickListener(this);
    }

    private void addControl() {
        btnDangNhap = (Button) findViewById(R.id.btnDN);
        btnThoat = (Button)  findViewById(R.id.btnExit);
        ckLuu = (CheckBox) findViewById(R.id.ckLuu);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnExit){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            // Setting Alert Dialog Title
            alertDialogBuilder.setTitle("Xác nhận để thoát..!!!");
            // Icon Of Alert Dialog
            alertDialogBuilder.setIcon(R.drawable.question);
            // Setting Alert Dialog Message
            alertDialogBuilder.setMessage("Bạn có muốn thoát?");
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    //Đóng Activity hiện tại
                    finish();
                }
            });

            alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"Bạn đã click vào nút không đồng ý",Toast.LENGTH_SHORT).show();
                }
            });
            alertDialogBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Bạn đã click vào nút hủy",Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if(view.getId() == R.id.btnDN){
            if(ckLuu.isChecked()){
                Toast.makeText(this,"Bạn đã lưu thông tin", Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(this,"Bạn chưa lưu thông tin", Toast.LENGTH_LONG).show();
            }
        }
    }
}