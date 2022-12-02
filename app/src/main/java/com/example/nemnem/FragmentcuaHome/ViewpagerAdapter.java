package com.example.nemnem.FragmentcuaHome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Trangchu();
            case 1:
                return new Giohang();
            case 2:
                return new Thongbao();
            case 3:
                return new Caidat();
        }
        return new Trangchu();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
