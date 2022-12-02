package com.example.nemnem.Fragmentcuagiohang;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Viewpagergiohang extends FragmentStateAdapter {
    public Viewpagergiohang(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Dieukien();
            case 1: return new Tatca();
        }
      return new Dieukien();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
