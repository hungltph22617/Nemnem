package com.example.nemnem.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.nemnem.Adapter.HomeAdapter;
import com.example.nemnem.R;
import com.example.nemnem.lv1;
import com.example.nemnem.lv2;
import com.example.nemnem.lv3;
import com.example.nemnem.lv4;
import com.example.nemnem.lv5;
import com.example.nemnem.model.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Thongtincuahang extends Fragment {

    ListView lv;
    ViewPager pager;
    BottomNavigationView bot;
    HomeAdapter adapterr;
    ArrayList<home> list = new ArrayList<>();

    public Thongtincuahang() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thongtincuahang, container, false);
        lv = view.findViewById(R.id.lv);
        adapterr = new HomeAdapter(getActivity(), R.layout.itemshome, list);
        list.add(new home(R.drawable.logonemnem, "Thông tin chi tiết cửa hàng", "Địa chỉ: SN41, Hải Thượng Lãn … "));
        list.add(new home(R.drawable.nemchua, "Thông tin chi tiết sản phẩm", "Nem chua có nhiều loại: Nem dài,… "));
        list.add(new home(R.drawable.kd, "Giấy chứng nhận", "Nem chua thanh hóa cổ truyền"));
        list.add(new home(R.drawable.attp, "Giấy chứng nhận", "Kiểm định an toàn thực phẩm"));
        list.add(new home(R.drawable.cn, "Chi nhánh", "Thành lập và mở rộng chi nhánh"));
        lv.setAdapter(adapterr);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), lv1.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), lv2.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), lv3.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), lv4.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), lv5.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
        return view;
    }
}