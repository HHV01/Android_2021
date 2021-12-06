package com.example.customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = {"1","ablum1","Kpop"};
        listview = (ListView) findViewById(R.id.idListView);
        ListViewAdapter adapter = new ListViewAdapter(this, items);
        listview.setAdapter(adapter);
    }
}