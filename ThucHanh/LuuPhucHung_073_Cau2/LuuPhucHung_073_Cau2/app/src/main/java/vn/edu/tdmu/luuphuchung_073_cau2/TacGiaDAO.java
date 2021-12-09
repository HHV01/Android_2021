package vn.edu.tdmu.luuphuchung_073_cau2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TacGiaDAO {
    public static ArrayList<TacGia>getAll(Context context){
        ArrayList<TacGia>ds= new ArrayList<>();
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("Select * from tblAuthors", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int ma = cs.getInt(0);
            String ten =cs.getString(1);
            String sodt = cs.getString(2);
            String diachi = cs.getString(3);
            TacGia tg = new TacGia(ma,ten,sodt,diachi);
            ds.add(tg);
            cs.moveToNext();

        }
        cs.close();
        db.close();
        return ds;
    }
    public  static  boolean delete (Context context, int ma){
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("tblAuthors","ID=?", new String[]{ma+""});
        return  (row>0);

    }
}
