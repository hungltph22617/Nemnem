package com.example.nemnem.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public static final String NAME_DB = "DUANLTMT";
    public static final int VERSION_DB = 1;
    public SQLite(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sanpham = "CREATE TABLE Sanpham(" +
                "masp INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tensp text," +
                "soluong int," +
                "dongia int)";
        db.execSQL(sanpham);
        String nguoimua = "CREATE TABLE Nguoimua(" +
                "ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ten text," +
                "diachi text," +
                "sdt int)";
        db.execSQL(nguoimua);
        String giohang = "CREATE TABLE Giohang(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tensp text," +
                "soluong int," +
                "dongia int)";
        db.execSQL(giohang);
        String lichsu = "CREATE TABLE Lichsu(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tensp text," +
                "dongia int)";
        db.execSQL(lichsu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Sanpham");
        db.execSQL("DROP TABLE IF EXISTS Nguoimua");
        db.execSQL("DROP TABLE IF EXISTS Giohang");
        db.execSQL("DROP TABLE IF EXISTS Lichsu");
        onCreate(db);
    }
}
