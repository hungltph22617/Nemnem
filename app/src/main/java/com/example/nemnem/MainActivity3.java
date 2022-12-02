package com.example.nemnem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nemnem.Fragment.Doanhthu;
import com.example.nemnem.Fragment.Donhang;
import com.example.nemnem.Fragment.Home;
import com.example.nemnem.Fragment.Nguoimua;
import com.example.nemnem.Fragment.Sanpham;
import com.example.nemnem.Fragment.Thongtincuahang;
import com.example.nemnem.Fragment.Top;
import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView nav;
    private static final int Home = 0;
    private static final int Donhang = 1;
    private static final int Sanpham = 2;
    private static final int Nguoimua = 3;
    private static final int Doanhthu = 4;
    private static final int Top = 5;
    private static final int Thongtincuahang = 6;
    private int Banchinh = Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer);
        nav = findViewById(R.id.nav);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(this);
        replaceFragment(new Home());
        nav.getMenu().findItem(R.id.nav_home).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            if(Banchinh != Home){
                replaceFragment(new Home());
                Banchinh = Home;
            }
        }else if(id == R.id.nav_donhang){
            if(Banchinh != Donhang){
                replaceFragment(new Donhang());
                Banchinh = Donhang;
            }
        }else if(id == R.id.nav_sanpham){
            if(Banchinh != Sanpham){
                replaceFragment(new Sanpham());
                Banchinh = Sanpham;
            }
        }else if(id == R.id.nav_nguoimua){
            if(Banchinh != Nguoimua){
                replaceFragment(new Nguoimua());
                Banchinh = Nguoimua;
            }
        }else if(id == R.id.nav_doanhthu){
            if(Banchinh != Doanhthu){
                replaceFragment(new Doanhthu());
                Banchinh = Doanhthu;
            }
        }else if(id == R.id.nav_top){
            if(Banchinh != Top){
                replaceFragment(new Top());
                Banchinh = Top;
            }
        }else if(id == R.id.nav_ttch){
            if(Banchinh != Thongtincuahang){
                replaceFragment(new Thongtincuahang());
                Banchinh = Thongtincuahang;
            }
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.danhgia:
                Intent intent = new Intent(MainActivity3.this, Danhgia.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}