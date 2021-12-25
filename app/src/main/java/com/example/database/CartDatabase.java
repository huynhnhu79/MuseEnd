package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class CartDatabase extends SQLiteOpenHelper {

    public static final int DB_VERSION= 1;
    public static final String DB_NAME= "cart.sqlite";
    public static final String TBL_NAME= "CART";
    public static final String COL_C_ID = "C_Id";
    public static final String COL_C_NAME = " C_Name";
    public static final String COL_C_PRICE = "W_Price";
    public static final String COL_C_PHOTO = "C_Photo";
    public CartDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_C_NAME + " VARCHAR(100), " + COL_C_PRICE + " REAL, " + COL_C_PHOTO + " BLOB) ";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);
    }


    public boolean insertData(String name, double price, byte[] photo){
        try{
            SQLiteDatabase db= getWritableDatabase();
            String sql= "INSERT INTO " + TBL_NAME + " VALUES(null, ?, ?, ?)";
            SQLiteStatement statement= db.compileStatement(sql);
            statement.bindString(1,name);
            statement.bindDouble(2,price);
            statement.bindBlob(3,photo);

            statement.executeInsert();
            return true;
        }catch (Exception ex){
            return false;
        }
    }



    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getReadableDatabase();
        return  db.rawQuery(sql,null);
    }

    }



