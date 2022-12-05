package com.example.nemnem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;

import com.example.nemnem.Adapter.DanhGiaAdapter;
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.model.SanPham;

import java.util.ArrayList;

public class Danhgia extends AppCompatActivity {
    SanphamDao sanphamDao;
    DanhGiaAdapter danhGiaAdapter;
    ArrayList<SanPham> list;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhgia);
        lv = findViewById(R.id.lv_danhgia);
        sanphamDao = new SanphamDao(getApplicationContext());
        sanphamDao.open();
        list = sanphamDao.selectAll();
        danhGiaAdapter = new DanhGiaAdapter(sanphamDao, list);
        lv.setAdapter(danhGiaAdapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Danhgia.this, MainActivity3.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}