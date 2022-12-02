package com.example.nemnem.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nemnem.R;
import com.example.nemnem.model.thongbao;

import java.util.ArrayList;

public class ThongbaoAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<thongbao> list = new ArrayList<>();

    public ThongbaoAdapter(Context mContext, ArrayList<thongbao> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        ImageView imgtb;
        TextView txttb;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemthongbao, null);
            holder = new ViewHolder();
            holder.imgtb = convertView.findViewById(R.id.imgtb);
            holder.txttb = convertView.findViewById(R.id.txttb);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imgtb.setImageResource(list.get(position).getAnh());
        holder.txttb.setText(list.get(position).getTbtd());
        return convertView;
    }
}
