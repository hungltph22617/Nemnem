package com.example.nemnem.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nemnem.Database.SQLite;
import com.example.nemnem.model.GioHang;

import java.util.ArrayList;

public class GioHangDAO {
    SQLite dbHelper;
    SQLiteDatabase db;

    public GioHangDAO(Context context){
        dbHelper = new SQLite(context);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public long insert(GioHang objGHang){
        ContentValues cv = new ContentValues();
        cv.put(GioHang.COL_NAME, objGHang.getTensp());
        cv.put(GioHang.COL_NUM, objGHang.getSoluong());
        cv.put(GioHang.COL_PRICE, objGHang.getDongia());

        long res = db.insert(GioHang.TB_NAME, null, cv);
        return res;
    }

    public int delete(GioHang objGHang){
        int res = db.delete(GioHang.TB_NAME, "masp = ?", new String[]{ objGHang.getMasp()+""});

        return res;
    }

    public int update(GioHang objGHang){
        ContentValues cv = new ContentValues();
        cv.put(GioHang.COL_NAME, objGHang.getTensp());
        cv.put(GioHang.COL_NUM, objGHang.getSoluong());
        cv.put(GioHang.COL_PRICE, objGHang.getDongia());

        int res = db.update(GioHang.TB_NAME, cv, "id = ?", new String[]{objGHang.getMasp()+""});
        return res;
    }

    public ArrayList<GioHang> selectAll(){
        ArrayList<GioHang> listLop = new ArrayList<GioHang>();
        String[] ds = new String[]{"*"};

        Cursor cs = db.query(GioHang.TB_NAME, ds,null,null,null,null,null);

        if(cs.moveToFirst()){
            while(!(cs.isAfterLast())){
                GioHang objGHang = new GioHang();
                objGHang.setMasp(cs.getInt(0));
                objGHang.setTensp(cs.getString(1));
                objGHang.setSoluong(cs.getInt(2));
                objGHang.setDongia(cs.getInt(3));
                listLop.add(objGHang);

                cs.moveToNext();
            }
        }
        return listLop;
    }

    public ArrayList<GioHang> selectAll2(){
        String sql = "SELECT tensp, SUM(soluong), SUM(dongia) FROM Giohang GROUP BY tensp";
        ArrayList<GioHang> list = new ArrayList<>();

        Cursor cs = db.rawQuery(sql, new String[]{});
        if (cs.moveToFirst()){
            while (!(cs.isAfterLast())){
                GioHang objGH = new GioHang();
                objGH.setTensp(cs.getString(0));
                objGH.setSoluong(cs.getInt(1));
                objGH.setDongia(cs.getInt(2));
                list.add(objGH);

                cs.moveToNext();
            }
        }
        return list;
    }
}
