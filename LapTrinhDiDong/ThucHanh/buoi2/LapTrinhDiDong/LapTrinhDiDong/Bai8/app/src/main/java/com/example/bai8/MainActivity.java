package com.example.bai8;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button btnChuyenDoi;
    private TextView tvAmLich;
    private EditText etDuonglich;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChuyenDoi = (Button) findViewById(R.id.btnChuyenDoi);
        tvAmLich = (TextView) findViewById(R.id.tvAmLich);
        etDuonglich = (EditText) findViewById(R.id.etDuongLich);
        // Activity is listener
        btnChuyenDoi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String can[]= {"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String chi[]= {"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
        String dl= etDuonglich.getText().toString();
        int n = Integer.parseInt(dl);
        String am = can[n%10] + " "+ chi[n%12];
        tvAmLich.setText(am);
    }
}