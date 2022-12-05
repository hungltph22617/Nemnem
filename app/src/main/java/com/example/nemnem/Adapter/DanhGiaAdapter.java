package com.example.nemnem.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.Fragment.Sanpham;
import com.example.nemnem.R;
import com.example.nemnem.model.SanPham;

import java.util.ArrayList;

public class DanhGiaAdapter extends BaseAdapter {

    SanphamDao sanphamDao;
    ArrayList<SanPham> list;

    public DanhGiaAdapter(SanphamDao sanphamDao, ArrayList<SanPham> list) {
        this.sanphamDao = sanphamDao;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        SanPham objSP = list.get(position);
        return objSP;
    }

    @Override
    public long getItemId(int position) {
        SanPham objSP = list.get(position);
        return objSP.getMasp();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null){
            v = View.inflate(parent.getContext(), R.layout.itemdanhgia, null);
        } else v = convertView;
        final SanPham objSP = list.get(position);
        final int index = position;

        TextView tv_ten = v.findViewById(R.id.tv_tenspdanhgia);
        TextView tv_gia = v.findViewById(R.id.tv_danhgiasanpham);

        tv_ten.setText(objSP.getTensp()+"");
        tv_gia.setText(objSP.getDanhgia()+"");
        return v;
    }
}
