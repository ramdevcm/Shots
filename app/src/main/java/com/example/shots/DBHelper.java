package com.example.shots;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_QR = "create table "+ DBConst.TABLE_NAME_QR+"( "+ DBConst.QRCODE+" tinytext,"+ DBConst.DATE+" DATE);";
    private static final String DROP_TABLE_QR = "drop table if exists "+ DBConst.TABLE_NAME_QR;
    private static final String CREATE_TABLE_BR = "create table "+ DBConst.TABLE_NAME_BR+"( "+ DBConst.BRCODE+" tinytext,"+ DBConst.DATE+" DATE);";
    private static final String DROP_TABLE_BR = "drop table if exists "+ DBConst.TABLE_NAME_BR;

    public DBHelper(Context context){
        super(context, DBConst.DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_QR);
        db.execSQL(CREATE_TABLE_BR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(DROP_TABLE_BR);
        db.execSQL(DROP_TABLE_QR);
        onCreate(db);
    }

    public void saveToLocalDatabase_QR(String QR, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConst.QRCODE,QR);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        contentValues.put(DBConst.DATE,date);
        database.insert(DBConst.TABLE_NAME_QR,null,contentValues);
    }

    public void saveToLocalDatabase_BR(String BR, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConst.BRCODE,BR);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        contentValues.put(DBConst.DATE,date);
        database.insert(DBConst.TABLE_NAME_BR,null,contentValues);
    }



    public Cursor readFromLocalDatabase_QR(SQLiteDatabase database){
        String[] projection = {DBConst.QRCODE,DBConst.DATE};
        return (database.query(DBConst.TABLE_NAME_QR,projection,null,null,null,null,DBConst.DATE));
    }

    public Cursor readFromLocalDatabase_BR(SQLiteDatabase database){
        String[] projection = {DBConst.BRCODE,DBConst.DATE};
        return (database.query(DBConst.TABLE_NAME_BR,projection,null,null,null,null,DBConst.DATE));
    }


}
