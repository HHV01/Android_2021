package com.example.quanlysinhvien;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Notify {
    public static void exit(Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        //Setting Alert Dialog Title
        alertDialogBuilder.setTitle(("Xác nhân để thoát...!"));
        alertDialogBuilder.setMessage("Bạn có muốn thoát?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(1);
            }
        });
        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
