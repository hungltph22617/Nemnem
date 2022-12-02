package com.example.nemnem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nemnem.model.classlv1;

import java.util.ArrayList;

public class Lv1Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<classlv1> list = new ArrayList<>();

    public Lv1Adapter(Context context, ArrayList<classlv1> list) {
        this.context = context;
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
        ImageView img1;
        TextView td1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemslv1, null);
            holder = new ViewHolder();
            holder.img1 = convertView.findViewById(R.id.img1);
            holder.td1 = convertView.findViewById(R.id.td1);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img1.setImageResource(list.get(position).getHinh());
        holder.td1.setText(list.get(position).getTieude());
        return convertView;
    }
}
