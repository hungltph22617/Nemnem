package com.example.nemnem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.nemnem.model.classlv1;

import java.util.ArrayList;
import java.util.List;

public class lv1 extends AppCompatActivity {
    ViewFlipper viewlv1;
    List<String> list = new ArrayList<>();
    ListView lvlv1;
    ArrayList<classlv1> listt = new ArrayList<>();
    Lv1Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv1);
        viewlv1 = findViewById(R.id.viewlv1);
        list.add("https://bucket.nhanh.vn/store3/103046/bn/bn4.png");
        list.add("https://bucket.nhanh.vn/store3/103046/bn/bn5.png");
        for(int i = 0; i < list.size(); i++){
            ImageView img = new ImageView(this);
            Glide.with(this).load(list.get(i)).into(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            viewlv1.addView(img);
        }
        viewlv1.setFlipInterval(3000);
        viewlv1.setAutoStart(true);
        Animation slide = AnimationUtils.loadAnimation(this, R.anim.slide);
        Animation slide2 = AnimationUtils.loadAnimation(this, R.anim.slide2);
        viewlv1.setInAnimation(slide);
        viewlv1.setOutAnimation(slide2);
        lvlv1 = findViewById(R.id.lvlv1);
        adapter = new Lv1Adapter(this, listt);
        listt.add(new classlv1(R.drawable.mapnongcong, "Địa chỉ cửa hàng"));
        listt.add(new classlv1(R.drawable.logonemnem, "Tầm nhìn và sứ mệnh"));
        listt.add(new classlv1(R.drawable.bacnem, "Lịch sử hình thành"));
        listt.add(new classlv1(R.drawable.bn4, "Thương hiệu nổi tiếng"));
        lvlv1.setAdapter(adapter);
        lvlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(lv1.this, Vitridialy.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(lv1.this, Tamnhinsumenh.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(lv1.this, Lichsuhinhthanh.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(lv1.this, Thuonghieunoitieng.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }
}