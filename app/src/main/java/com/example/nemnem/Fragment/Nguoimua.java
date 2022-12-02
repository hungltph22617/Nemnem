package com.example.nemnem.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nemnem.Adapter.NguoimuaAdapter;
import com.example.nemnem.Dao.NguoimuaDao;
import com.example.nemnem.R;
import com.example.nemnem.model.nguoimua;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Nguoimua extends Fragment {
    RecyclerView renm;
    FloatingActionButton flnm;
    ArrayList<nguoimua> list = new ArrayList<>();
    NguoimuaAdapter adapter;
    NguoimuaDao dao;

    public Nguoimua() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nguoimua, container, false);
        renm = view.findViewById(R.id.renm);
        flnm = view.findViewById(R.id.flnm);
        dao = new NguoimuaDao(getActivity());
        list = dao.selectAll();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        renm.setLayoutManager(manager);
        adapter = new NguoimuaAdapter(getActivity(), list);
        renm.setAdapter(adapter);
        flnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater1 = getLayoutInflater();
                View view1 = inflater1.inflate(R.layout.themnm, null);
                builder.setView(view1);
                Dialog dialog = builder.create();
                builder.show();
                TextInputEditText edten = view1.findViewById(R.id.edtennm);
                TextInputEditText eddc = view1.findViewById(R.id.eddc);
                TextInputEditText edsdt = view1.findViewById(R.id.edsdt);
                Button themnm = view1.findViewById(R.id.themnm);
                Button xoanm = view1.findViewById(R.id.xoanm);
                themnm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ten = edten.getText().toString();
                        String dc = eddc.getText().toString();
                        String sdt = String.valueOf(edsdt.getText().toString());
                        nguoimua nguoimua = new nguoimua(ten, dc, Integer.parseInt(sdt));
                        if(ten.equals("") | dc.equals("") | sdt.equals("")){
                            Toast.makeText(getActivity(), "Không được để trống", Toast.LENGTH_SHORT).show();
                        }else if(dao.insert(nguoimua)){
                            Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                            list.clear();
                            dialog.dismiss();
                            list.addAll(dao.selectAll());
                            adapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                xoanm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edten.setText("");
                        eddc.setText("");
                        edsdt.setText("");
                    }
                });
            }
        });
        return view;
    }
}