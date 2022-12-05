package com.example.nemnem.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nemnem.Database.SQLite;
import com.example.nemnem.model.Lichsu;

import java.util.ArrayList;

public class LichSuDAO {
    SQLite dbHelper;
    SQLiteDatabase db;

    public LichSuDAO(Context context){
        dbHelper = new SQLite(context);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public long insert(Lichsu objLS){
        ContentValues cv = new ContentValues();
        cv.put(Lichsu.COL_NAME, objLS.getTensp());
        cv.put(Lichsu.COL_PRICE, objLS.getDongia());

        long res = db.insert(Lichsu.TB_NAME, null, cv);
        return res;
    }

    public ArrayList<Lichsu> selectAll(){
        ArrayList<Lichsu> listLop = new ArrayList<Lichsu>();
        String[] ds = new String[]{"*"};

        Cursor cs = db.query(Lichsu.TB_NAME, ds,null,null,null,null,null);

        if(cs.moveToFirst()){
            while(!(cs.isAfterLast())){
                Lichsu objLop = new Lichsu();
                objLop.setMasp(cs.getInt(0));
                objLop.setTensp(cs.getString(1));
                objLop.setDongia(cs.getInt(2));
                listLop.add(objLop);

                cs.moveToNext();
            }
        }
        return listLop;
    }

}
