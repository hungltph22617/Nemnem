package com.example.nemnem.FragmentcuaHome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nemnem.Adapter.ThongbaoAdapter;
import com.example.nemnem.R;
import com.example.nemnem.model.thongbao;

import java.util.ArrayList;

public class Thongbao extends Fragment {
    ListView tblv;
    ArrayList<thongbao> list = new ArrayList<>();
    ThongbaoAdapter adapter;


    public Thongbao() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thongbao, container, false);
        tblv = view.findViewById(R.id.tblv);
        adapter = new ThongbaoAdapter(getActivity(), list);
        list.add(new thongbao(R.mipmap.sale, "Khuyến mại 20% (tất cả sản phẩm)."));
        list.add(new thongbao(R.mipmap.tuyen, "Tuyển dụng nhân viên giao hàng nhanh, sản xuất."));
        tblv.setAdapter(adapter);
        tblv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(getActivity(), "Khuyến mại 20% (tất cả sản phẩm).", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        break;
                }
            }
        });
        return view;
    }
}