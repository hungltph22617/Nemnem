package com.example.nemnem.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nemnem.R;
import com.example.nemnem.model.caidat;
import java.util.ArrayList;

public class CaidatAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<caidat> list = new ArrayList<>();

    public CaidatAdapter(Context context, ArrayList<caidat> list) {
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
        TextView txttd;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemscaidat, null);
            holder = new ViewHolder();
            holder.txttd = convertView.findViewById(R.id.txttd);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txttd.setText(list.get(position).getCdtd());
        return convertView;
    }
}