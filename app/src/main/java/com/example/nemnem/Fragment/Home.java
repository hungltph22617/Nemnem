package com.example.nemnem.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nemnem.Adapter.HomeAdapter;
import com.example.nemnem.Adapter.SanphamAdapter;
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.FragmentcuaHome.ViewpagerAdapter;
import com.example.nemnem.R;
import com.example.nemnem.model.home;
import com.example.nemnem.model.sanpham;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    ViewPager pager;
    BottomNavigationView bot;
    HomeAdapter adapterr;
//    RecyclerView rehome;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bot = view.findViewById(R.id.bot);
        pager = view.findViewById(R.id.pager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bot.getMenu().findItem(R.id.trangchu).setChecked(true);
                        break;
                    case 1:
                        bot.getMenu().findItem(R.id.giohang).setChecked(true);
                        break;
                    case 2:
                        bot.getMenu().findItem(R.id.thongbao).setChecked(true);
                        break;
                    case 3:
                        bot.getMenu().findItem(R.id.caidat).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bot.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trangchu:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.giohang:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.thongbao:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.caidat:
                        pager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        return view;
    }
}