package com.example.nemnem.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.nemnem.Database.SQLite;
import com.example.nemnem.model.SanPham;
import java.util.ArrayList;

public class SanphamDao {
    SQLite sqLite;
    public SanphamDao(Context context){
        sqLite = new SQLite(context);
    }
    SQLiteDatabase db;

    public void open(){
        db = sqLite.getWritableDatabase();
    }

    public ArrayList<SanPham> selectAll(){
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase db = sqLite.getReadableDatabase();
        String sql = "SELECT * FROM Sanpham";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            SanPham sp = new SanPham();
            sp.setMasp(cursor.getInt(0));
            sp.setTensp(cursor.getString(1));
            sp.setSoluong(cursor.getInt(2));
            sp.setDongia(cursor.getInt(3));
            sp.setDanhgia(cursor.getString(4));
            list.add(sp);
            cursor.moveToNext();
        }
        return list;
    }
//    public boolean insert(SanPham sp){
//        SQLiteDatabase db = sqLite.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("tensp", sp.getTensp());
//        values.put("soluong", sp.getSoluong());
//        values.put("dongia", sp.getDongia());
//        values.put("danhgia", sp.getDanhgia());
//        long row = db.insert("Sanpham", null, values);
//        return (row > 0);
//    }
    public boolean update(SanPham sp){
        SQLiteDatabase db = sqLite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tensp", sp.getTensp());
        values.put("soluong", sp.getSoluong());
        values.put("dongia", sp.getDongia());
        values.put("danhgia", sp.getDanhgia());
        long row = db.update("Sanpham", values,"masp=?", new String[]{sp.getMasp()+""});
        return (row > 0);
    }
    public boolean delete(int masp){
        SQLiteDatabase db = sqLite.getWritableDatabase();
        String sql = "DELETE FROM Sanpham where masp=?";
        long row = db.delete("Sanpham","masp=?", new String[]{masp+""});
        return (row > 0);
    }
}
