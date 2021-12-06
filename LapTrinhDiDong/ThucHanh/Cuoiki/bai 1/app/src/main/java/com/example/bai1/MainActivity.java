package com.example.bai1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnketqua,btnxoa,btndong;
    TextView txthoten,txthk1,txthk2,txtdtb,txtketqua,txthocluc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget();

        btndong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(getApplicationContext());
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý thoát chương trình không?");
// Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
//Nút Cancel
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
//Tạo dialog
                AlertDialog al = b.create();
//Hiển thị
                al.show();
            }
        });
    }


    private void widget() {
        btnketqua = (Button) findViewById(R.id.btnketqua);
        btnxoa = (Button) findViewById(R.id.btnxoa);
        btndong = (Button) findViewById(R.id.btndong);
        txthoten = (TextView) findViewById(R.id.txthoten);
        txthk1 = (TextView) findViewById(R.id.txthk1);
        txthk2 = (TextView) findViewById(R.id.txthk2);
        txtdtb = (TextView) findViewById(R.id.txtdtb);
        txtketqua = (TextView) findViewById(R.id.txtketqua);
        txthocluc = (TextView) findViewById(R.id.txthocluc);
    }
}