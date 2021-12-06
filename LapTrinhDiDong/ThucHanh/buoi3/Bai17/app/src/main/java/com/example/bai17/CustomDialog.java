package com.example.bai17;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CustomDialog extends Dialog {

    interface AddAlbumListener {
        public void addAlbumEntered(String addAlbum);
    }

    public Context context;

    private EditText editTextMaAlbum;
    private EditText editTextTenAlbum;
    private Button buttonOK;
    private Button buttonCancel;
    private Button btnXoa;
    private int pos =  -1;
    private AddAlbumListener listener;


    public CustomDialog(Context context, AddAlbumListener listener, int pos) {
        super(context);
        this.context = context;
        this.listener = listener;
        this.pos = pos;
    }
    public CustomDialog(Context context, AddAlbumListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_custom_dialog);

        this.editTextMaAlbum = (EditText) findViewById(R.id.editText_MaAlbum);
        this.editTextTenAlbum = (EditText) findViewById(R.id.editText_TenAlbum);
        this.buttonOK = (Button) findViewById(R.id.button_ok);
        this.buttonCancel  = (Button) findViewById(R.id.button_cancel);
        this.btnXoa        = (Button) findViewById(R.id.btnXoa);
        editTextMaAlbum.requestFocus();
        if(pos != -1){
            editTextMaAlbum.setText(AlbumActivity.lst.get(pos).getMaAlbum());
            editTextTenAlbum.setText(AlbumActivity.lst.get(pos).getTenAlbum());
        }


        this.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextMaAlbum.setText("");
                editTextTenAlbum.setText("");
//                editTextMaAlbum.isFocusableInTouchMode();

                editTextMaAlbum.requestFocus();
            }
        });

        this.buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOKClick();
            }
        });
        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCancelClick();
            }
        });
    }

    // User click "OK" button.
    private void buttonOKClick()  {
        String maAlbum = this.editTextMaAlbum.getText().toString();
        String tenAlbum = this.editTextTenAlbum.getText().toString();
        if(pos != -1){
            AlbumActivity.lst.get(pos).setMaAlbum(maAlbum);
            AlbumActivity.lst.get(pos).setTenAlbum(tenAlbum);
            AlbumActivity.adapter.notifyDataSetChanged();
            this.dismiss();

            return;
        }
        ArrayList<BaiHat> lstBH = new ArrayList<>();


        Album album = new Album(maAlbum, tenAlbum, lstBH);
        AlbumActivity.lst.add(album);
        this.dismiss(); // Close Dialog

        if(this.listener!= null)  {
            this.listener.addAlbumEntered(maAlbum);
        }
    }

    // User click "Cancel" button.
    private void buttonCancelClick()  {
        this.dismiss();
    }
}
