package com.example.interfaceonclicklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin	= (Button)findViewById(R.id.btnLogin);
        btnLogout	= (Button)findViewById(R.id.btnLogout);
        //Xử lý sự kiện cho 2 button
        btnLogin.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Lấy id từng button
        switch(v.getId()){
            case R.id.btnLogin:
                // Hiện thị thông báo trong vòng vài giây
                Toast.makeText(getApplication(), " Bạn đang Click vào Button Login", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnLogout:
                Toast.makeText(getApplication(), " Bạn đang Click vào Button Logout", Toast.LENGTH_LONG).show();
                break;
        }
    }
}