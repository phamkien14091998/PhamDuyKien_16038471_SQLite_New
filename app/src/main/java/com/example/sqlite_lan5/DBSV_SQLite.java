package com.example.sqlite_lan5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSV_SQLite extends SQLiteOpenHelper {
    public DBSV_SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void query(String sql){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor queryCursor(String sql){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }

    public long insert(SinhVien sinhVien){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("mssv",sinhVien.getMssv());
        values.put("tenSV",sinhVien.getTenSV());
        return sqLiteDatabase.insert("SinhVien",null,values);
    }

    public int update(SinhVien sinhVien){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("mssv",sinhVien.getMssv());
        values.put("tenSV",sinhVien.getTenSV());
        return sqLiteDatabase.update("SinhVien",values,"id="+sinhVien.getId(),null);
    }
    public int delete(int id){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.delete("SinhVien","id="+id,null);
    }

}
