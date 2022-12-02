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

import com.example.nemnem.Dao.NguoimuaDao;
import com.example.nemnem.R;
import com.example.nemnem.model.nguoimua;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class NguoimuaAdapter extends RecyclerView.Adapter<NguoimuaAdapter.ViewHolder>{
    private Context context;
    private ArrayList<nguoimua> list = new ArrayList<>();
    NguoimuaDao dao;

    public NguoimuaAdapter(Context context, ArrayList<nguoimua> list) {
        this.context = context;
        this.list = list;
        dao = new NguoimuaDao(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemsnm, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        nguoimua nguoimua = list.get(position);
        holder.txtten.setText(list.get(position).getTen());
        holder.txtdiachi.setText(list.get(position).getDiachi());
        holder.txtsdt.setText(String.valueOf(list.get(position).getSdt()));
        holder.imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sua(nguoimua);
            }
        });
        holder.imgx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dao.delete(nguoimua.getMa())){
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

    private void sua(nguoimua nguoimua) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.suanm, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        builder.show();
        TextInputEditText ten = view.findViewById(R.id.tennm);
        TextInputEditText dc = view.findViewById(R.id.dcnm);
        TextInputEditText sdt = view.findViewById(R.id.sdtnm);
        Button sua = view.findViewById(R.id.unm);
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nguoimua.setTen(ten.getText().toString());
                nguoimua.setDiachi(dc.getText().toString());
                nguoimua.setSdt(Integer.parseInt(sdt.getText().toString()));
                if(ten.getText().toString().equals("") | dc.getText().toString().equals("") | sdt.getText().toString().equals("")){
                    Toast.makeText(context, "Không được để trống", Toast.LENGTH_SHORT).show();
                }else if(dao.update(nguoimua)){
                    Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
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
        TextView txtten, txtdiachi, txtsdt;
        ImageView imge, imgx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.txtten);
            txtdiachi = itemView.findViewById(R.id.txtdiachi);
            txtsdt = itemView.findViewById(R.id.txtsdt);
            imge = itemView.findViewById(R.id.imge);
            imgx = itemView.findViewById(R.id.imgx);
        }
    }
}
