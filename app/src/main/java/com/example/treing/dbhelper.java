package com.example.treing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class dbhelper extends SQLiteOpenHelper {
    public static final String DB_NAME    = "my database";
    public static final String NAME_TABLE = "STUDENTS";
    public static final String KEY_ID     = "id";
    public static final String KEY_NAME   = "name";
    public static final String    KEY_AGE    = "age";

    public dbhelper(Context context) {
        super(context, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+NAME_TABLE+"("+KEY_ID+"ID INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+" varcher(50),"+KEY_AGE+"Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+NAME_TABLE);
        onCreate(db);
    }

    public void add(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(KEY_NAME,item.getName());
        cv.put(KEY_AGE,item.getAge());
        db.insert(NAME_TABLE,null,cv);

    }

    public ArrayList<Item> getAll(){
        ArrayList<Item> items = new ArrayList<>();
        SQLiteDatabase db     = this.getWritableDatabase();
        String query          = " Select * from "+NAME_TABLE;
        Cursor cursor         = db.rawQuery(query,null);
        if (cursor.getCount() != 0){
           while (cursor.moveToNext()){
               String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
               int    age  = cursor.getInt(cursor.getColumnIndex(KEY_AGE));
               Item item = new Item(name,age);
               items.add(item);
           }
        }
        return items;
    }
}
