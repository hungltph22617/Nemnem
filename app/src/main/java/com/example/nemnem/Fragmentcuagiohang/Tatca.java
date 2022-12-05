package com.example.nemnem.Fragmentcuagiohang;

import android.app.Fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nemnem.Adapter.GioHangAdapter;
import com.example.nemnem.Dao.GioHangDAO;
import com.example.nemnem.R;
import com.example.nemnem.model.GioHang;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tatca#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tatca extends androidx.fragment.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tatca() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tatca.
     */
    // TODO: Rename and change types and number of parameters
    public static Tatca newInstance(String param1, String param2) {
        Tatca fragment = new Tatca();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tatca, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_dh = view.findViewById(R.id.btn_dathang);
        RecyclerView recyclerView = view.findViewById(R.id.rv_giohang);
        GioHangDAO gioHangDAO = new GioHangDAO(getContext());
        gioHangDAO.open();
        ArrayList<GioHang> list = gioHangDAO.selectAll();
        GioHangAdapter gioHangAdapter = new GioHangAdapter(list, gioHangDAO);
        recyclerView.setAdapter(gioHangAdapter);
        btn_dh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "";
                for (int i = 0; i<list.size(); i++){
                    a = a + list.get(i).getTensp() +" x "+list.get(i).getSoluong()+"\n";
                }
                list.clear();
            }
        });
    }
}