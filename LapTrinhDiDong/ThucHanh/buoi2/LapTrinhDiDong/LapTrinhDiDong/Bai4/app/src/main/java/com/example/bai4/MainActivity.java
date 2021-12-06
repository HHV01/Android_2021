package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCel, btnFar, btnClear;
    EditText editFar, editCel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        btnFar.setOnClickListener(this);
        btnCel.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    private void addControls() {
        btnCel = (Button) findViewById(R.id.btnCel);
        btnFar = (Button) findViewById(R.id.btnFar);
        btnClear =(Button)  findViewById(R.id.btnClear);
        editFar = (EditText) findViewById(R.id.editFar);
        editCel = (EditText) findViewById(R.id.editCel);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnFar){
            String sCel = editCel.getText().toString();
            if(sCel.isEmpty()){
                return;
            }
            double cel = Double.parseDouble( sCel);
            double far = cel * 9/5 + 32;
            editFar.setText("" + far);
        }
        else  if(view.getId() == R.id.btnCel){
            // Xu ly doi do F -> C
            String sFar = editFar.getText().toString();
            if(sFar.isEmpty()){
                return;
            }
            double far = Double.parseDouble(sFar);
            double cel = (far - 32) * 5/9;
            editCel.setText(" "+cel);
        } else if(view.getId() == R.id.btnClear){
            editCel.setText("");
            editFar.setText("");
            return;
        }
    }
}