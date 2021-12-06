package vn.edu.tdmu.luuphuchung_073_cau2;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper (Context context){
        super(context,"books.db", null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table  tblAuthors (ID integer primary key autoincrement," +
                "fullName text, Tel text, address text)";
        db.execSQL(sql);
        sql = "Insert into tblAuthors values(null,'hung','123','dong thap')";
        db.execSQL(sql);
        sql = "Insert into tblAuthors values(null,'hung','123','dong thap')";
        db.execSQL(sql);
        sql = "Insert into tblAuthors values(null,'hung','123','dong thap')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists tblAuthors");
        onCreate(db);

    }
}

