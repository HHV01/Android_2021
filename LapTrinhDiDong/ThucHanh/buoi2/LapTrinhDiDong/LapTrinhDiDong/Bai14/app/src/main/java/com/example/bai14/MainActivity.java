package com.example.bai14;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textViewHT;
    ListView list;
    String[] lstProvine = {
            "Hue",
            "Da Nang",
            "Ha Noi",
            "Binh Duong",
            "A",
            "BC",
            "DEF"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewHT = (TextView) findViewById(R.id.textView);

        CustomList adapter = new CustomList(MainActivity.this, lstProvine);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textViewHT = (TextView) findViewById(R.id.textView);
                textViewHT.setText(lstProvine[+position]);
            }
        });


    }
}