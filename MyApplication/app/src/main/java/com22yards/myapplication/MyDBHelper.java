package com22yards.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jerry on 3/18/2017.
 */

public class MyDBHelper extends SQLiteOpenHelper{

    private static  final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "userinfo.db";
    public static final String TABLE_NAME = "userDetails";
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_USERNAME= "user_uname";
    public static final String COLUMN_PASSWORD = "user_pword";


    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertdata(String username, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,username);
        contentValues.put(COLUMN_PASSWORD,password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }


    public void updatedata(String username, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,username);
        contentValues.put(COLUMN_PASSWORD,password);
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLE_NAME,contentValues,COLUMN_USERNAME + "=" +" \""+username +"\" ",null);
        db.close();
    }

    public void deletedata(String username){
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_USERNAME +"=" +"\"" +username +"\"";
        db.execSQL(query);
    }

    public String databaseString(){
        String dbString = "";

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)) != null){
                dbString += cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                dbString += "  ";
                dbString += cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                dbString += "\n";
            }
            cursor.moveToNext();
        }
        db.close();
        return dbString;
    }
}
