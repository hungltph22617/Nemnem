package com.example.nemnem.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public static final String NAME_DB = "DUANLTMT4";
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
                "dongia int, " +
                "danhgia text)";
        db.execSQL(sanpham);
        String insert_sanpham = "INSERT INTO Sanpham VALUES (1, 'Nem phùng', 5, 30000, 'ngon'), (2, 'Nem nắm Giao Thủy', 5, 45000, 'ngon')," +
                "(3, 'Nem chua Thanh Hóa', 5, 25000, 'ngon'), (4, 'Nem lụi Huế', 5, 50000, 'ngon'), (5, 'Nem nướng Ninh Hòa', 5, 60000, 'ngon')";
        db.execSQL(insert_sanpham);
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
        String sanphambanchay = "CREATE TABLE SanPhamBanChay(" +
                "tensp text PRIMARY KEY," +
                "soLuong int)";
        db.execSQL(sanphambanchay);
        String insert_sanphambanchay = "INSERT INTO SanPhamBanChay VALUES ('Nem phùng',0), ('Nem nắm Giao Thủy',0)," +
                "('Nem chua Thanh Hóa',0), ('Nem lụi Huế',0), ('Nem nướng Ninh Hòa',0)";
        db.execSQL(insert_sanphambanchay);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Sanpham");
        db.execSQL("DROP TABLE IF EXISTS Nguoimua");
        db.execSQL("DROP TABLE IF EXISTS Giohang");
        db.execSQL("DROP TABLE IF EXISTS Lichsu");
        db.execSQL("DROP TABLE IF EXISTS SanPhamBanChay");
        onCreate(db);
    }
}
