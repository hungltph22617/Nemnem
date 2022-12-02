package com.example.nemnem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

import com.example.nemnem.R;
import com.example.nemnem.model.home;
import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<home> list;

    public HomeAdapter(Context context, int layout, ArrayList<home> list) {
        this.context = context;
        this.layout = layout;
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
        ImageView imghome;
        TextView tieude;
        TextView noidung;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemshome, null);
            holder = new ViewHolder();
            holder.imghome = convertView.findViewById(R.id.imghome);
            holder.tieude = convertView.findViewById(R.id.tieude);
            holder.noidung = convertView.findViewById(R.id.noidung);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imghome.setImageResource(list.get(position).getHinh());
        holder.tieude.setText(list.get(position).getTieude());
        holder.noidung.setText(list.get(position).getNoidung());
        return convertView;
    }
}
//public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
//    private Context context;
//    private int layout;
//    ArrayList<home> list = new ArrayList<>();
//
//    public HomeAdapter(Context context, int layout, ArrayList<home> list) {
//        this.context = context;
//        this.layout = layout;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.itemshome, null);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.imghome.setImageResource(list.get(position).getHinh());
//        holder.tieude.setText(list.get(position).getTieude());
//        holder.noidung.setText(list.get(position).getNoidung());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView imghome;
//        TextView tieude;
//        TextView noidung;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imghome = itemView.findViewById(R.id.imghome);
//            tieude = itemView.findViewById(R.id.tieude);
//            noidung = itemView.findViewById(R.id.noidung);
//        }
//    }
//}
