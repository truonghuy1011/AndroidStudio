package com.example.spliteexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databases extends SQLiteOpenHelper {
    public Databases(Context context, String name, SQLiteDatabase.CursorFactory factory,int Version){
        super(context,name,factory,Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void Querydata(String sql){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor Getdata(String sql){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);
    }
}
