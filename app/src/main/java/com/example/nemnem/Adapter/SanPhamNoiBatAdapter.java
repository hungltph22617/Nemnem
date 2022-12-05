package com.example.nemnem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.SanPham;

import java.util.ArrayList;

public class SanPhamNoiBatAdapter extends RecyclerView.Adapter<SanPhamNoiBatAdapter.ViewHolderSanPhamNoiBat>{

    public Context context;
    public ArrayList<SanPham> list = new ArrayList<>();
    SanphamDao dao;

    public SanPhamNoiBatAdapter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
        dao = new SanphamDao(context);
    }

    @NonNull
    @Override
    public ViewHolderSanPhamNoiBat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemsanphamnoibat, null);
        return new ViewHolderSanPhamNoiBat(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSanPhamNoiBat holder, int position) {
        SanPham sp = list.get(position);
        holder.txtsp.setText(sp.getTensp());
        holder.slsp.setText(String.valueOf(sp.getSoluong()));
        holder.dgsp.setText(String.valueOf(sp.getDongia()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderSanPhamNoiBat extends RecyclerView.ViewHolder {
        TextView txtsp, slsp, dgsp;

        public ViewHolderSanPhamNoiBat(@NonNull View itemView) {
            super(itemView);
            txtsp = itemView.findViewById(R.id.txtsp);
            slsp = itemView.findViewById(R.id.slsp);
            dgsp = itemView.findViewById(R.id.dgsp);
        }
    }
}
