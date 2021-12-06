package com.example.bai3_final;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

class MyEvent implements View.OnClickListener{
    private int getGCD(int a, int b){
        if(a == 0) return b;
        return getGCD(b%a, a);
    }
    @Override
    public void onClick(View v) {
        EditText edtA = (EditText) v.getRootView().findViewById(R.id.editTextA);
        EditText edtB = (EditText) v.getRootView().findViewById(R.id.editTextB);
        TextView textViewKQ = (TextView) v.getRootView().findViewById(R.id.textViewKetQua);
        String chuoiA = edtA.getText().toString();
        int soA = Integer.parseInt(chuoiA);
        String chuoiB = edtB.getText().toString();
        int soB = Integer.parseInt(chuoiB);
        int ucln = getGCD(soA, soB);
        textViewKQ.setText(String.valueOf(ucln));;
    }
}
