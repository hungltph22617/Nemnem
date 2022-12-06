package com.example.nemnem.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nemnem.Database.SQLite;
import com.example.nemnem.model.GioHang;
import com.example.nemnem.model.Lichsu;
import com.example.nemnem.model.SanPham;
import com.example.nemnem.model.SanPhamBanChay;

import java.util.ArrayList;

public class SanPhamBanChayDAO {
    SQLite dbHelper;
    SQLiteDatabase db;

    public SanPhamBanChayDAO(Context context){
        dbHelper = new SQLite(context);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public boolean update(SanPhamBanChay sp){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tensp", sp.getTensp());
        values.put("soLuong", sp.getSoLuong());
        long row = db.update("SanPhamBanChay", values,"tensp=?", new String[]{sp.getTensp()+""});
        return (row > 0);
    }

    public ArrayList<SanPhamBanChay> selectAll(){
        ArrayList<SanPhamBanChay> listLop = new ArrayList<SanPhamBanChay>();
        String[] ds = new String[]{"*"};

        Cursor cs = db.query(SanPhamBanChay.TB_NAME, ds,null,null,null,null,null);

        if(cs.moveToFirst()){
            while(!(cs.isAfterLast())){
                SanPhamBanChay sanPhamBanChay = new SanPhamBanChay();
                sanPhamBanChay.setTensp(cs.getString(0));
                sanPhamBanChay.setSoLuong(cs.getInt(1));
                listLop.add(sanPhamBanChay);

                cs.moveToNext();
            }
        }
        return listLop;
    }
}
