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
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.GioHang;
import com.example.nemnem.model.sanpham;

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {

    public Context context;
    public ArrayList<GioHang> list = new ArrayList<>();
    GioHangDAO gioHangDAO;

    public GioHangAdapter(Context context, ArrayList<GioHang> list, GioHangDAO gioHangDAO) {
        this.context = context;
        this.list = list;
        gioHangDAO = new GioHangDAO(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemgiohang, null);
        return new GioHangAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsp, slsp, dgsp;
        ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsp = itemView.findViewById(R.id.txtspgiohang);
            slsp = itemView.findViewById(R.id.slspgiohang);
            dgsp = itemView.findViewById(R.id.dgspgiohang);
            delete = itemView.findViewById(R.id.deletegiohang);
        }
    }


}
