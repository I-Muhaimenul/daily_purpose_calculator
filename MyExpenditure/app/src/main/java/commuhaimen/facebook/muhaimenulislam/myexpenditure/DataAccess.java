package commuhaimen.facebook.muhaimenulislam.myexpenditure;

/**
 * Created by Muhaimenul Islam on 11/26/2016.
 */
import android.*;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataAccess extends SQLiteOpenHelper{

    //DB Information
    public static final int DB_VER=1;
    public static final String DB_NAME="item.db";
    public static final String TABLE_NAME="items";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String AMOUNT="amount";
    public static final String DATE="date";
    public static final String ABOUT="about";

    public DataAccess(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE " + TABLE_NAME + " ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, amount REAL, date TEXT, about TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String amount, String date, String about){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AMOUNT, amount);
        contentValues.put(DATE, date);
        contentValues.put(ABOUT, about);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }
}
