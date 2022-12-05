package com.example.nemnem.FragmentcuaHome;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.nemnem.Adapter.CaidatAdapter;
import com.example.nemnem.LienkettaikhoanNH;
import com.example.nemnem.MainActivity2;
import com.example.nemnem.R;
import com.example.nemnem.model.caidat;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Caidat extends Fragment {
    ListView cdlv;
    CaidatAdapter adapter;
    ArrayList<caidat> list = new ArrayList<>();
    Switch s;
    Button btnlogin, btnregister;
    Dialog dialog1;

    public Caidat() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caidat, container, false);
        s = view.findViewById(R.id.s);
        cdlv = view.findViewById(R.id.cdlv);
        btnregister = view.findViewById(R.id.btnregister);
        adapter = new CaidatAdapter(getActivity(), list);
        list.add(new caidat("Đăng xuất"));
        list.add(new caidat("Hỗ trợ khách hàng"));
        list.add(new caidat("Đánh giá ứng dụng"));
//        list.add(new caidat("Liên kết tài khoản ngân hàng"));
        cdlv.setAdapter(adapter);
        cdlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Bạn có chắc chắn muốn đăng xuất không?");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //chuyển sang activity đăng nhập
                            }
                        });
                        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        break;
                    case 1:
                        Dialog dialog = new Dialog(getContext());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_hotrokhachhang);
                        TextView textView = dialog.findViewById(R.id.callNow);
                        textView.setOnClickListener(v -> {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+"0123456789"));
                            startActivity(callIntent);
                        });
                        dialog.show();
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        break;
                    case 2:
                        dialog1 = new Dialog(getContext());
                        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog1.setContentView(R.layout.dialog_danhgiapp);
                        ImageView img1 = dialog1.findViewById(R.id.star1);
                        ImageView img2 = dialog1.findViewById(R.id.star2);
                        ImageView img3 = dialog1.findViewById(R.id.star3);
                        ImageView img4 = dialog1.findViewById(R.id.star4);
                        ImageView img5 = dialog1.findViewById(R.id.star5);
                        TextView tv = dialog1.findViewById(R.id.xacnhanDanhGia);
                        onClickDanhGia(img1,img2,img3,img4,img5,tv);
                        dialog1.show();
                        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        break;
//                    case 3:
//                        Intent intent3 = new Intent(getActivity(), LienkettaikhoanNH.class);
//                        startActivity(intent3);
//                        break;
                }
            }
        });
        btnlogin = view.findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void onClickDanhGia(ImageView img1,ImageView img2,ImageView img3,ImageView img4,ImageView img5,TextView textView){
        img1.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.ic_baseline_star_24);
            img2.setImageResource(R.drawable.ic_baseline_star_outline_24);
            img3.setImageResource(R.drawable.ic_baseline_star_outline_24);
            img4.setImageResource(R.drawable.ic_baseline_star_outline_24);
            img5.setImageResource(R.drawable.ic_baseline_star_outline_24);
        });
        img2.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.ic_baseline_star_24);
            img2.setImageResource(R.drawable.ic_baseline_star_24);
            img3.setImageResource(R.drawable.ic_baseline_star_outline_24);
            img4.setImageResource(R.drawable.ic_baseline_star_outline_24);
            img5.setImageResource(R.drawable.ic_baseline_star_outline_24);
        });
        img3.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.ic_baseline_star_24);
            img2.setImageResource(R.drawable.ic_baseline_star_24);
            img3.setImageResource(R.drawable.ic_baseline_star_24);
            img4.setImageResource(R.drawable.ic_baseline_star_outline_24);
            img5.setImageResource(R.drawable.ic_baseline_star_outline_24);
        });
        img4.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.ic_baseline_star_24);
            img2.setImageResource(R.drawable.ic_baseline_star_24);
            img3.setImageResource(R.drawable.ic_baseline_star_24);
            img4.setImageResource(R.drawable.ic_baseline_star_24);
            img5.setImageResource(R.drawable.ic_baseline_star_outline_24);
        });
        img5.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.ic_baseline_star_24);
            img2.setImageResource(R.drawable.ic_baseline_star_24);
            img3.setImageResource(R.drawable.ic_baseline_star_24);
            img4.setImageResource(R.drawable.ic_baseline_star_24);
            img5.setImageResource(R.drawable.ic_baseline_star_24);
        });
        textView.setOnClickListener(v -> {
            Snackbar.make(getView(),"Cảm ơn đánh giá của bạn",2000).show();
            dialog1.dismiss();
        });
    }
}