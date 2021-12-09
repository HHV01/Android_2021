package com.example.bai17;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuanLyActivity extends AppCompatActivity  implements  View.OnClickListener{

    Button btnDate, btnThemBaiHat;
    EditText edtTen;
    EditText txtNgay;
    ListView lv;
    Spinner sp;
    ArrayList<BaiHat> lstBH;
    CustomAdapterBaiHat adapterBaiHat;
    CustomSpinner adapterSpinner;
    ArrayList<String> lstAlbum = new ArrayList<>();
    int albumDuocChon = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);
        getWigets();

        //Spinner cheat

        for(int i = 0; i < AlbumActivity.lst.size(); i++){
            lstAlbum.add(AlbumActivity.lst.get(i).getTenAlbum());
        }
        adapterSpinner = new CustomSpinner(QuanLyActivity.this, AlbumActivity.lst, lstAlbum);
        adapterSpinner.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        sp.setAdapter(adapterSpinner);
        sp.setOnItemSelectedListener(setItem);

        //Thêm bài hát
        btnThemBaiHat.setOnClickListener(this);
        btnDate.setOnClickListener(this);
        lv.setOnItemLongClickListener(exit);

    }
    private  void getWigets(){
        txtNgay = (EditText) findViewById(R.id.txtNgay);
        edtTen=(EditText) findViewById(R.id.edtTenBH);

        btnDate=(Button)findViewById(R.id.btndate);
        btnThemBaiHat=(Button)findViewById(R.id.btnThemBaiHat);


        sp = (Spinner) findViewById(R.id.spinner);
        lv = (ListView) findViewById(R.id.lv_Contact);

    }
    private AdapterView.OnItemSelectedListener setItem = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            //lstBH.clear();


            albumDuocChon = position;
//            if(AlbumActivity.lst.get(albumDuocChon).getLstBaiHat().isEmpty()){
//                return;
//            }
            lstBH = AlbumActivity.lst.get(albumDuocChon).getLstBaiHat();
            adapterBaiHat = new CustomAdapterBaiHat(QuanLyActivity.this, lstBH);
            lv.setAdapter(adapterBaiHat);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btndate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtNgay.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if(v.getId() == R.id.btnThemBaiHat){
            String tenBH = edtTen.getText().toString();
            String ngay = txtNgay.getText().toString();
            BaiHat bh = new BaiHat(tenBH, ngay);
            //lstBH.add(bh);
            AlbumActivity.lst.get(albumDuocChon).getLstBaiHat().add(bh);
            adapterBaiHat.notifyDataSetChanged();
            //onResume();
        }

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        adapterBaiHat.notifyDataSetChanged();
//
//    }

    AdapterView.OnItemLongClickListener exit = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
            exit(view , position);
            return false;
        }
    };

    public void exit(View view, int position){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Remove");
        // Icon Of Alert Dialog

        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Bạn có muốn xóa ???");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                lstBH.remove(position);
                adapterBaiHat.notifyDataSetChanged();
            }
        });
        alertDialogBuilder.setNeutralButton("Không", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}