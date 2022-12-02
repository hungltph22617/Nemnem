package com.example.nemnem.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.sanpham;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ViewHolder>{
    public Context context;
    public ArrayList<sanpham> list = new ArrayList<>();
    SanphamDao dao;

    public SanphamAdapter(Context context, ArrayList<sanpham> list) {
        this.context = context;
        this.list = list;
        dao = new SanphamDao(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemsanpham, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        sanpham sp = list.get(position);
        holder.txtsp.setText(list.get(position).getTensp());
        holder.slsp.setText(String.valueOf(list.get(position).getSoluong()));
        holder.dgsp.setText(String.valueOf(list.get(position).getDongia()));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suasp(sp);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dao.delete(sp.getMasp())){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(dao.selectAll());
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void suasp(sanpham sp) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.suasp, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        builder.show();
        TextInputEditText edutensp = view.findViewById(R.id.edutensp);
        TextInputEditText eduslsp = view.findViewById(R.id.edusl);
        TextInputEditText edudgsp = view.findViewById(R.id.edudg);
        Button btnupdate = view.findViewById(R.id.btnupdate);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setTensp(edutensp.getText().toString());
                sp.setSoluong(Integer.parseInt(eduslsp.getText().toString()));
                sp.setDongia(Integer.parseInt(edudgsp.getText().toString()));
                if(edutensp.getText().toString().equals("") | eduslsp.getText().toString().equals("") | edudgsp.getText().toString().equals("")){
                    Toast.makeText(context, "Không được để trống", Toast.LENGTH_SHORT).show();
                }else if(dao.update(sp)){
                    Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    dialog.dismiss();
                    list.addAll(dao.selectAll());
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsp, slsp, dgsp;
        ImageView edit, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsp = itemView.findViewById(R.id.txtsp);
            slsp = itemView.findViewById(R.id.slsp);
            dgsp = itemView.findViewById(R.id.dgsp);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
