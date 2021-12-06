package com.example.bai17;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnXem, btnQuanLy;
    static int status = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(status == -1) {
            ArrayList<BaiHat> lstBH = new ArrayList<>();
            ArrayList<BaiHat> lstBH1 = new ArrayList<>();
            BaiHat bh = new BaiHat("Huong", "20/06/2001");
            BaiHat bh1 = new BaiHat("1 phut'", "11/10/2000");

            lstBH.add(bh);
            lstBH.add(bh1);
            Album album = new Album("Album 1", "Van Cute Qua", lstBH);
            Album album2 = new Album("Album 2", "Peo Cute =))))", lstBH1);
            Album album3 = new Album("Album 3", "Đầu 6 đít tiểu học ", lstBH1);
            AlbumActivity.lst.add(album);
            AlbumActivity.lst.add(album2);
            AlbumActivity.lst.add(album3);
            status = 11231;
        }
        getWigets();
        btnXem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(intent);
            }
        });
        btnThem.setOnClickListener(callDialog);
        btnQuanLy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuanLyActivity.class);
                startActivity(intent);
            }
        });


    }

    private void getWigets() {
        btnQuanLy = (Button) findViewById(R.id.btnQL);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnXem = (Button) findViewById(R.id.btnXem);
    }

    OnClickListener callDialog = new OnClickListener() {
        @Override
        public void onClick(View view) {

            buttonOpenDialogClicked();
        }
    };
    private void buttonOpenDialogClicked()  {
        CustomDialog.AddAlbumListener listener = new CustomDialog.AddAlbumListener() {
            @Override
            public void addAlbumEntered(String addAlbum) {

            }
        };
        final CustomDialog dialog = new CustomDialog(this, listener);

        dialog.show();
    }
}
