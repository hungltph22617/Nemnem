package com.example.nemnem.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nemnem.Dao.LichSuDAO;
import com.example.nemnem.R;
import com.example.nemnem.model.Lichsu;

import java.util.ArrayList;

public class LichSuAdapter extends BaseAdapter {
    LichSuDAO lichSuDAO;
    ArrayList<Lichsu> list;

    public LichSuAdapter(LichSuDAO lichSuDAO, ArrayList<Lichsu> list) {
        this.lichSuDAO = lichSuDAO;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        Lichsu objLS = list.get(position);
        return objLS;
    }

    @Override
    public long getItemId(int position) {
        Lichsu objLS = list.get(position);
        return objLS.getMasp();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null){
            v = View.inflate(parent.getContext(), R.layout.itemlichsu, null);
        } else v = convertView;
        final Lichsu objLS = list.get(position);
        final int index = position;

        TextView tv_ten = v.findViewById(R.id.tv_tensplichsu);
        TextView tv_gia = v.findViewById(R.id.tv_giasplichsu);

        tv_ten.setText(objLS.getTensp()+"");
        tv_gia.setText(objLS.getDongia()+"");
        return v;
    }
}

