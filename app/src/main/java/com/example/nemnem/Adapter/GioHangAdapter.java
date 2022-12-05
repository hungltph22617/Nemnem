package com.example.nemnem.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public GioHangAdapter(ArrayList<GioHang> list, GioHangDAO gioHangDAO) {
        this.list = list;
        this.gioHangDAO = gioHangDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.itemgiohang, null);
        return new GioHangAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int index = position;
        GioHang objGHang = list.get(position);
        holder.txtsp.setText(list.get(position).getTensp());
        holder.slsp.setText(String.valueOf(list.get(position).getSoluong()));
        holder.dgsp.setText(String.valueOf(list.get(position).getDongia()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa");
                builder.setMessage("Xác nhận xóa?");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq = gioHangDAO.delete(objGHang);
                        if (kq>0){
                            list.remove(index);
                            notifyDataSetChanged();
                            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        } dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();
            }
        });
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
