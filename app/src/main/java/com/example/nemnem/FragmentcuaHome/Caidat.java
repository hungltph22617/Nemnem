package com.example.nemnem.FragmentcuaHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.example.nemnem.Adapter.CaidatAdapter;
import com.example.nemnem.Hotrokhachhang;
import com.example.nemnem.LienkettaikhoanNH;
import com.example.nemnem.MainActivity2;
import com.example.nemnem.R;
import com.example.nemnem.model.caidat;
import java.util.ArrayList;

public class Caidat extends Fragment {
    ListView cdlv;
    CaidatAdapter adapter;
    ArrayList<caidat> list = new ArrayList<>();
    Switch s;
    Button btnlogin, btnregister;

    public Caidat() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caidat, container, false);
        s = view.findViewById(R.id.s);
        cdlv = view.findViewById(R.id.cdlv);
        adapter = new CaidatAdapter(getActivity(), list);
        list.add(new caidat("Đăng xuất"));
        list.add(new caidat("Hỗ trợ khách hàng"));
        list.add(new caidat("Đánh giá ứng dụng"));
        list.add(new caidat("Liên kết tài khoản ngân hàng"));
        cdlv.setAdapter(adapter);
        cdlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        Intent intent = new Intent(getActivity(), Hotrokhachhang.class);
                        startActivity(intent);
                        break;
                    case 2:
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), LienkettaikhoanNH.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
        btnlogin = view.findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
        return view;
    }
}