package com.example.de3_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    Button btnTinhbmi, btnXoa, btnDong;
    EditText edtten, edtchieucao, edtcannang;
    TextView txtbmi, txtchuandoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget();
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtten.setText("");
                edtchieucao.setText("");
                edtcannang.setText("");
            }
        });


        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                //Setting Alert Dialog Title
                alertDialogBuilder.setIcon(R.drawable.images);
                alertDialogBuilder.setTitle(("Xác nhân để thoát...!"));
                alertDialogBuilder.setMessage("Bạn có muốn thoát?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
        btnTinhbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( _isEmpty()){
                    Toast.makeText(getApplication(), "Các trường (*) không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                double chieuCao = Double.parseDouble(edtchieucao.getText().toString());
                double canNang = Double.parseDouble(edtcannang.getText().toString());
                double diemBMI = (canNang/(chieuCao*chieuCao));
                int tmp =(int) (diemBMI*1000.0);
                double ex = 0.01;
                if(tmp % 10 < 5){
                    ex = 0;
                }
                tmp /= 10;
                diemBMI = tmp/100.0;
                diemBMI += ex;
                String ketQua = "";
                if(diemBMI <18){
                    ketQua = " Người gầy";
                } else if(diemBMI < 24.9){
                    ketQua = " Người bình thường";
                }else if(diemBMI < 29.9){
                    ketQua = " Người béo phì độ I";
                }else if(diemBMI < 34.9){
                    ketQua = " Người béo phì độ II";
                }else {
                    ketQua = " Người béo phì độ III";
                }




                txtbmi.setText("BMI " + diemBMI);
                txtchuandoan.setText("Chuẩn đoán bạn "+edtten.getText().toString() + ketQua);


            }
        });
    }

    boolean _isEmpty() {
        return (edtten.getText().toString().isEmpty() || edtcannang.getText().toString().isEmpty() || edtchieucao.getText().toString().isEmpty());
    }




        private void widget() {
        btnTinhbmi = (Button) findViewById(R.id.btntinhbmi);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnDong = (Button) findViewById(R.id.btnDong);
        edtten = (EditText) findViewById(R.id.edtten);
        edtchieucao = (EditText) findViewById(R.id.edtchieucao);
        edtcannang = (EditText) findViewById(R.id.edtcannang);
        txtbmi = (TextView) findViewById(R.id.txtbmi);
        txtchuandoan = (TextView) findViewById(R.id.txtchuandoan);

    }
}