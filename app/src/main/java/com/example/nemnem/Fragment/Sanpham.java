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

import com.example.nemnem.Adapter.SanphamAdapter;
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.sanpham;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Sanpham extends Fragment {
    RecyclerView resp;
    FloatingActionButton flsp;
    SanphamDao dao;
    ArrayList<sanpham> list = new ArrayList<>();
    SanphamAdapter adapter;

    public Sanpham() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sanpham, container, false);
        resp = view.findViewById(R.id.resp);
        flsp = view.findViewById(R.id.flsp);
        dao = new SanphamDao(getActivity());
        list = dao.selectAll();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        resp.setLayoutManager(manager);
        adapter = new SanphamAdapter(getActivity(), list);
        resp.setAdapter(adapter);
        flsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater1 = getLayoutInflater();
                View view1 = inflater1.inflate(R.layout.themsp, null);
                builder.setView(view1);
                Dialog dialog = builder.create();
                builder.show();
                TextInputEditText tensp = view1.findViewById(R.id.edtensp);
                TextInputEditText slsp = view1.findViewById(R.id.edslsp);
                TextInputEditText dgsp = view1.findViewById(R.id.eddgsp);
                Button them = view1.findViewById(R.id.btnthem);
                Button xoa = view1.findViewById(R.id.btnxoa);
                them.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ten = tensp.getText().toString();
                        String sl = String.valueOf(slsp.getText().toString());
                        String dg = String.valueOf(dgsp.getText().toString());
                        sanpham sp = new sanpham(ten, Integer.parseInt(sl), Integer.parseInt(dg));
                        if(ten.equals("") | sl.equals("") | dg.equals("")){
                            Toast.makeText(getActivity(), "Không được để trống", Toast.LENGTH_SHORT).show();
                        }else if(dao.insert(sp)){
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
                xoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tensp.setText("");
                        slsp.setText("");
                        dgsp.setText("");
                    }
                });
            }
        });
        return view;
    }
}