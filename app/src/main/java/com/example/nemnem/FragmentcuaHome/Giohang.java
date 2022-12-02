package com.example.nemnem.FragmentcuaHome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nemnem.Fragmentcuagiohang.Viewpagergiohang;
import com.example.nemnem.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Giohang extends Fragment {
    Viewpagergiohang adapter;
    TabLayout tabgh;
    ViewPager2 pagergh;

    public Giohang() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_giohang, container, false);
        tabgh = view.findViewById(R.id.tabgh);
        pagergh = view.findViewById(R.id.pagergh);
        adapter = new Viewpagergiohang(getActivity());
        pagergh.setAdapter(adapter);
        new TabLayoutMediator(tabgh, pagergh, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Điều kiện khi mua hàng");
                        break;
                    case 1:
                        tab.setText("Tất cả");
                        break;
                }
            }
        }).attach();
        return view;
    }
}