package com.example.onclickinxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Thêm sự kiện tại đây có tham số là View
    public void clickMe(View v){
        // kiem tra bằng dùng phương thức getID() của view so sánh với id của button
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