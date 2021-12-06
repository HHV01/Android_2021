package com.example.kiemtragiuaky_ketquahoctap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXemKetQua, btnXoa, btnDong;
    EditText edtHoten, edtHK1, edtHK2, edtDTB, edtKetQua, edtHocLuc;
    TextView txtHoTen, txtHK1, txtHK2, txtDTB, txtKetQua, txtHocLuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();

        btnXemKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( _isEmpty()){
                    Toast.makeText(getApplication(), "Các trường (*) không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                double diemHK1 = Double.parseDouble(edtHK1.getText().toString());
                double diemHK2 = Double.parseDouble(edtHK2.getText().toString());
                double diemTB = (diemHK1 + diemHK2*2)/3;
                int tmp =(int) (diemTB*1000.0);
                double ex = 0.01;
                if(tmp % 10 < 5){
                    ex = 0;
                }
                tmp /= 10;
                diemTB = tmp/100.0;
                diemTB += ex;
                String ketQua = "";
                if(diemTB >= 5.0){
                    ketQua = "Được lên lớp";
                } else{
                    ketQua = "Bị lưu ban";
                }
                String hocLuc = getXepLoai(diemTB);

                //Xuất kết quả
                edtHocLuc.setText(hocLuc);
                edtDTB.setText(diemTB + "");
                edtKetQua.setText(ketQua);

                txtHoTen.setText("Họ tên: " + edtHoten.getText().toString());
                txtHK1.setText("Điểm HK1: " + diemHK1);
                txtHK2.setText("Điểm HK2: " + diemHK2);
                txtDTB.setText("Điểm trung bình: " + diemTB );
                txtHocLuc.setText("Xếp loại: " + hocLuc);
                txtKetQua.setText("Kết quả: " + ketQua);

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHoten.setText("");
                edtHK1.setText("");
                edtHK2.setText("");
                edtDTB.setText("");
                edtKetQua.setText("");
                edtHocLuc.setText("");
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


    }
    String getXepLoai(double diemTB){
        if(diemTB >= 8.0 ) return "Giỏi";
        if(diemTB >= 6.5) return "Khá";
        if(diemTB >= 5.0) return "Trung bình";
        return "Yếu";
    }

    boolean _isEmpty(){
        return (edtHoten.getText().toString().isEmpty() || edtHK1.getText().toString().isEmpty() || edtHK2.getText().toString().isEmpty() );
    }
    void getWidgets(){
        btnXemKetQua = (Button) findViewById(R.id.btnXemKetQua);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnDong = (Button) findViewById(R.id.btnDong);

        edtHoten = (EditText) findViewById(R.id.edtFullName);
        edtHK1 = (EditText) findViewById(R.id.edtHK1);
        edtHK2 = (EditText) findViewById(R.id.edtHK2);
        edtKetQua = (EditText) findViewById(R.id.edtKetQua);
        edtDTB = (EditText) findViewById(R.id.edtDTB);
        edtHocLuc = (EditText) findViewById(R.id.edtHocLuc);

        txtHoTen = (TextView) findViewById(R.id.txtHoTen);
        txtHK1 = (TextView) findViewById(R.id.txtHK1);
        txtHK2 = (TextView) findViewById(R.id.txtHK2);
        txtDTB = (TextView) findViewById(R.id.txtDTB);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
        txtHocLuc = (TextView) findViewById(R.id.txtHocLuc);


    }
}