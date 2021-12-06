package com.example.bai9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    RadioButton rbtDaiHoc;
    Button btnGuiThongTin;
    EditText edtHoTen, edtCMND;
    RadioGroup rbgBangCap;
    AlertDialog.Builder alertDialogBuilder;
    String hoTen, cmnd, bangCap, docSach = "", docBao = "", docCode = "";
    CheckBox cbxDocBao, cbxDocSach, cbxDocCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        rbtDaiHoc.setChecked(true);
        btnGuiThongTin.setOnClickListener(sendInfo);
    }
    private void addControl(){
        rbtDaiHoc = (RadioButton) findViewById(R.id.rdbDaiHoc);
        btnGuiThongTin = (Button) findViewById(R.id.btnGuiThongTin);
        edtCMND = (EditText)  findViewById(R.id.etCMND);
        edtHoTen = (EditText)  findViewById(R.id.etHocTen);
        rbgBangCap = (RadioGroup) findViewById(R.id.rbgBangCap);
        alertDialogBuilder = new AlertDialog.Builder(this);
        cbxDocBao  = (CheckBox) findViewById(R.id.cbDocBao);
        cbxDocSach = (CheckBox) findViewById(R.id.cbDocSach);
        cbxDocCode = (CheckBox) findViewById(R.id.cbDocCoding);

    }
    private final OnClickListener sendInfo = new OnClickListener() {
        @Override
        public void onClick(View view) {
            hoTen = edtHoTen.getText().toString();
            if(hoTen.length() <= 3){
                Toast.makeText(getApplication(), "Họ tên không hợp lệ!", Toast.LENGTH_LONG).show();
                return;
            }
            cmnd = edtCMND.getText().toString();
            boolean ok = true;
            if(cmnd.length() != 9){
                ok = false;
            }
            for(int i = 0; i < cmnd.length() && ok; i++){
                if(cmnd.charAt(i) > '9' || cmnd.charAt(i) < '0'){
                    ok = false;
                }
            }
            if(!ok){
                Toast.makeText(getApplication(), "CMND không hợp lệ!", Toast.LENGTH_LONG).show();
                return;
            }
            bangCap = ((RadioButton)findViewById(rbgBangCap.getCheckedRadioButtonId()) ).getText().toString();
//            Toast.makeText(getApplication(), bangCap, Toast.LENGTH_LONG).show();
            boolean cbxOK = false;
            if(cbxDocBao.isChecked()){
                docBao = cbxDocBao.getText().toString();
                cbxOK = true;
            }
            if(cbxDocSach.isChecked()){
                docSach = cbxDocSach.getText().toString();
                cbxOK = true;
            }
            if(cbxDocCode.isChecked()){
                docCode = cbxDocCode.getText().toString();
                cbxOK = true;
            }
            if(!cbxOK){
                Toast.makeText(getApplication(), "Cần chọn ít nhất 1 sở thích", Toast.LENGTH_LONG).show();
                return;
            }
            showInfo();




        }
        private void showInfo(){
            alertDialogBuilder.setTitle("Thông tin cá nhân");
            // Setting Alert Dialog Message hoTen + "\n" + cmnd + "\n" + bangCap
            String soThich = "Sở thích: " + docBao + " " + docSach + " " + docCode;


            alertDialogBuilder.setMessage(hoTen + "\n" + cmnd + "\n" + bangCap + "\n" + "Thông tin bổ sung: \n"
                    + soThich +  "\nSenior Programmer\n" + "Senior Saler");
            alertDialogBuilder.setCancelable(true);

            alertDialogBuilder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };
}