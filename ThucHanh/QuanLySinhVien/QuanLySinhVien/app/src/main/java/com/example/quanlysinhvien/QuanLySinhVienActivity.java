package com.example.quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuanLySinhVienActivity extends AppCompatActivity{
    Button btnThem;
    ListView lv;
    CustomAdapter adapter;
    ArrayList<SinhVien> lstStudent;
    SQLiteDatabase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sinh_vien);
        db  = openOrCreateDatabase(Login.DATABASE_NAME, MODE_PRIVATE, null);
        getWiget();

       btnThem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLySinhVienActivity.this, ThemSinhVienActivity.class);
                startActivity(intent);
            }
        });

        lstStudent =   getListStudent();
        adapter = new CustomAdapter(QuanLySinhVienActivity.this, R.layout.custom_list_sv_layout, lstStudent);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.context_xoa:
                SinhVien sv = lstStudent.get(i.position);
                db.delete("tbstudent", "id_student = ?", new String[] {sv.getId()});
                lstStudent.remove(i.position);
                adapter.notifyDataSetChanged();
                return true;
            case  R.id.context_sua:
                suaSinhVien(i.position);
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
    public void suaSinhVien(int index){


        SinhVien sv = lstStudent.get(index);
        Cursor cursor = db.rawQuery("select name_class from tbclass where id_class = ?", new String[] {sv.getId() + ""});
        String class_name = sv.getTenLop();



        Intent intent = new Intent(QuanLySinhVienActivity.this, SuaActivity.class);
        try{
            intent.putExtra("id", sv.getId());
            intent.putExtra("class_name", sv.getTenLop());

        } catch (Exception ex){
            Toast.makeText(getApplication(), "Lỗi ID", Toast.LENGTH_SHORT).show();
        }
        startActivity(intent);



    }

    private void getWiget(){
        btnThem  =   (Button) findViewById(R.id.btnThem);
        lv      =   (ListView) findViewById(R.id.lvDSSV);
    }
    private ArrayList<SinhVien> getListStudent(){
        ArrayList<SinhVien> lstStudent = new ArrayList<>();
        String query = "select name_student, id_student, id_class from tbstudent";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                SinhVien sv = new SinhVien();
                sv.setHoten(cursor.getString(0).toString());
                sv.setId(cursor.getString(1));
                String id_class = cursor.getString(2);
                Cursor cursor_tenlop = db.rawQuery("select name_class from tbclass where id_class = ?", new String[] {id_class});
                if(cursor_tenlop.moveToFirst()){
                    sv.setTenLop(cursor_tenlop.getString(0));
                }
                lstStudent.add(sv);
            }while(cursor.moveToNext());
        }
        return lstStudent;
    }

//    query += "id_class INTEGER NOT NULL,";
//    query += "code_student TEXT NOT NULL,";
//    query += "name_student TEXT NOT NULL,";
//    query += "gender_student TEXT NOT NULL,";
//    query += "birthday_student TEXT NOT NULL)";

}