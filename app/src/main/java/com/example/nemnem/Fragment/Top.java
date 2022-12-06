package com.example.nemnem.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nemnem.Adapter.GioHangAdapter;
import com.example.nemnem.Adapter.SanPhamBanChayAdapter;
import com.example.nemnem.Adapter.SanPhamNoiBatAdapter;
import com.example.nemnem.Dao.LichSuDAO;
import com.example.nemnem.Dao.SanPhamBanChayDAO;
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.SanPhamBanChay;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Top#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Top extends Fragment {
    RecyclerView recyclerView;
    SanPhamBanChayDAO sanPhamBanChayDAO;
    ArrayList<SanPhamBanChay> list;
    public static Top newInstance() {
        Top fragment = new Top();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_spbanchay);
        sanPhamBanChayDAO = new SanPhamBanChayDAO(getActivity());
        sanPhamBanChayDAO.open();
        list = sanPhamBanChayDAO.selectAll();
        Collections.sort(list, new Comparator<SanPhamBanChay>() {
            @Override
            public int compare(SanPhamBanChay sanPhamBanChay, SanPhamBanChay sp) {
                if (sanPhamBanChay.getSoLuong() == sp.getSoLuong()) {
                    return 0;
                }
                if (sanPhamBanChay.getSoLuong() < sp.getSoLuong()) {
                    return 1;
                }
                return -1;
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        SanPhamBanChayAdapter sanPhamBanChayAdapter = new SanPhamBanChayAdapter(getContext(), list);
        recyclerView.setAdapter(sanPhamBanChayAdapter);
    }
}