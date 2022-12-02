package com.example.nemnem.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nemnem.Database.SQLite;
import com.example.nemnem.model.nguoimua;

import java.util.ArrayList;

public class NguoimuaDao {
    SQLite sqLite;
    public NguoimuaDao(Context context){
        sqLite = new SQLite(context);
    }
    public ArrayList<nguoimua> selectAll(){
        ArrayList<nguoimua> list = new ArrayList<>();
        SQLiteDatabase db = sqLite.getReadableDatabase();
        String sql = "SELECT * FROM Nguoimua";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            nguoimua nm = new nguoimua();
            nm.setMa(cursor.getInt(0));
            nm.setTen(cursor.getString(1));
            nm.setDiachi(cursor.getString(2));
            nm.setSdt(cursor.getInt(3));
            list.add(nm);
            cursor.moveToNext();
        }
        return list;
    }
    public boolean insert(nguoimua nm){
        SQLiteDatabase db = sqLite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", nm.getTen());
        values.put("diachi", nm.getDiachi());
        values.put("sdt", nm.getSdt());
        long row = db.insert("Nguoimua", null, values);
        return (row > 0);
    }
    public boolean update(nguoimua nm){
        SQLiteDatabase db = sqLite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten", nm.getTen());
        values.put("diachi", nm.getDiachi());
        values.put("sdt", nm.getSdt());
        long row = db.update("Nguoimua", values,"ma=?", new String[]{nm.getMa()+""});
        return (row > 0);
    }
    public boolean delete(int ma){
        SQLiteDatabase db = sqLite.getWritableDatabase();
        String sql = "DELETE FROM Nguoimua where ma=?";
        long row = db.delete("Nguoimua","ma=?", new String[]{ma+""});
        return (row > 0);
    }
}
