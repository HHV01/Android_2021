package vn.edu.tdmu.luuphuchung_073_cau2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    TacGiaAdapter adapter;
    ArrayList<TacGia> dsTG= new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvTacGia);
        dsTG = TacGiaDAO.getAll(MainActivity.this);
       adapter = new TacGiaAdapter(MainActivity.this, R.layout.my_class, dsTG);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mnu_tg,menu);

    }
    public void confirmDelete(int pos) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Xác nhận xóa ");

        alertDialogBuilder.setMessage("Bạn có chắc xóa ");
        alertDialogBuilder.setCancelable(false);
        TacGia tg= dsTG.get(pos);
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TacGiaDAO.delete(MainActivity.this,tg.getID())){
                    Toast.makeText(MainActivity.this,"Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    dsTG.clear();
                    dsTG.addAll(TacGiaDAO.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();

                }
                else{
                    Toast.makeText(MainActivity.this,"Xoa  that bai ", Toast.LENGTH_SHORT).show();
                }

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



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuThem:

                return true;
            case R.id.mnuXoa:
                Notify.exit(this);
                return true;
            default:
                return super.onContextItemSelected(item);
        }



    }


}