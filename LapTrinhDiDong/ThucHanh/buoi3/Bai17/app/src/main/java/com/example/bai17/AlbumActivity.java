package com.example.bai17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    ListView lv;
    public static ArrayList<Album> lst = new ArrayList<>();
    ArrayList<BaiHat> lstBH = new ArrayList<>();
    static CustomList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ablum);


        lv              =   (ListView) findViewById(R.id.lvAlbum);
        adapter = new CustomList(AlbumActivity.this, lst);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(callDialog);
    }
    AdapterView.OnItemClickListener callDialog = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            buttonOpenDialogClicked(pos);
        }
    };
    private void buttonOpenDialogClicked(int pos)  {
        CustomDialog.AddAlbumListener listener = new CustomDialog.AddAlbumListener() {
            @Override
            public void addAlbumEntered(String addAlbum) {

            }
        };
        final CustomDialog dialog = new CustomDialog(this, listener, pos);

        dialog.show();
    }
}