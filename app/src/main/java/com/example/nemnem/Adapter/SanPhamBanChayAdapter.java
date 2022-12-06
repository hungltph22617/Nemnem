package com.example.nemnem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nemnem.Dao.GioHangDAO;
import com.example.nemnem.Dao.SanPhamBanChayDAO;
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.SanPham;
import com.example.nemnem.model.SanPhamBanChay;

import java.util.ArrayList;

public class SanPhamBanChayAdapter extends RecyclerView.Adapter<SanPhamBanChayAdapter.SPBanChayViewHolder>{
    public Context context;
    public ArrayList<SanPhamBanChay> list = new ArrayList<>();
    SanPhamBanChayDAO dao;

    public SanPhamBanChayAdapter(Context context, ArrayList<SanPhamBanChay> list) {
        this.context = context;
        this.list = list;
        dao = new SanPhamBanChayDAO(context);
    }

    @NonNull
    @Override
    public SPBanChayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanphambanchay, null);
        return new SPBanChayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SPBanChayViewHolder holder, int position) {
        SanPhamBanChay sanPhamBanChay = list.get(position);
        holder.tv_namesp.setText(sanPhamBanChay.getTensp());
        holder.tv_countsp.setText("Lượt bán: "+sanPhamBanChay.getSoLuong());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SPBanChayViewHolder extends RecyclerView.ViewHolder {
        TextView tv_namesp, tv_countsp;
        public SPBanChayViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_namesp = itemView.findViewById(R.id.tv_namesp);
            tv_countsp = itemView.findViewById(R.id.tv_countsp);
        }
    }
}
