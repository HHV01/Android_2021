package com.example.kiemtragiuaky_spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    ArrayList<String> lst = new ArrayList<>();
    int images[] = {R.drawable.cuctinhy, R.drawable.duongtu, R.drawable.luudiecphi, R.drawable.tranngocky};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spn);
        lst.add("Cúc Tịnh Y");
        lst.add("Dương Tử");
        lst.add("Lưu Diệc Phi");
        lst.add("Trần Ngọc Kỳ");
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, lst, images);
        sp.setAdapter(adapter);


    }
}