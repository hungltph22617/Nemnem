package com.example.nemnem.FragmentcuaHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nemnem.Adapter.SanPhamNoiBatAdapter;
import com.example.nemnem.Dao.SanphamDao;
import com.example.nemnem.R;
import com.example.nemnem.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class Trangchu extends Fragment {
    ViewFlipper viewflipper;
    List<String> list = new ArrayList<>();
    SanphamDao dao;
    ArrayList<SanPham> listSanPham = new ArrayList<>();
    SanPhamNoiBatAdapter adapterSanPham;
    RecyclerView recyclerView;

//    RecyclerView retc;

    public Trangchu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        viewflipper = view.findViewById(R.id.viewflipper);
        recyclerView = view.findViewById(R.id.retc);

        setRecycler();

//        retc = view.findViewById(R.id.retc);
        list.add("https://vifoodshop.com/wp-content/uploads/2019/07/nem-chua-chuan-thanh-hoa.jpg");
        list.add("https://vifoodshop.com/wp-content/uploads/2019/07/Cach_chon_Nem_Chua_Thanh_Hoa_Chinh_Goc.jpg");
        list.add("https://www.thatlangon.com/wp-content/uploads/2020/10/cach-lam-nem-chua-thanh-hoa-large.jpg");
        list.add("https://top10thanhhoa.com/wp-content/uploads/2021/08/nem-chua-thanh-hoa-4-min.jpg");
        list.add("https://halotravel.vn/wp-content/uploads/2020/07/PicsArt_07-22-11.41.55.jpg");
        for(int i = 0; i< list.size(); i++){
            ImageView img = new ImageView(getActivity());
            Glide.with(getActivity()).load(list.get(i)).into(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            viewflipper.addView(img);
        }
        viewflipper.setFlipInterval(3000);
        viewflipper.setAutoStart(true);
        Animation slide = AnimationUtils.loadAnimation(getActivity(), R.anim.slide);
        Animation slide2 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide2);
        viewflipper.setInAnimation(slide);
        viewflipper.setOutAnimation(slide2);
        return view;
    }
    private void setRecycler(){
        dao = new SanphamDao(getActivity());
        listSanPham = dao.selectAll();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        adapterSanPham = new SanPhamNoiBatAdapter(getActivity(), listSanPham);
        recyclerView.setAdapter(adapterSanPham);
    }
}