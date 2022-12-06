package com.example.nemnem.Fragmentcuagiohang;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;


import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nemnem.Adapter.GioHangAdapter;
import com.example.nemnem.Dao.GioHangDAO;
import com.example.nemnem.Dao.LichSuDAO;
import com.example.nemnem.Dao.SanPhamBanChayDAO;
import com.example.nemnem.Fragment.Home;
import com.example.nemnem.Fragment.Top;
import com.example.nemnem.FragmentcuaHome.Caidat;
import com.example.nemnem.R;
import com.example.nemnem.model.GioHang;
import com.example.nemnem.model.Lichsu;
import com.example.nemnem.model.SanPham;
import com.example.nemnem.model.SanPhamBanChay;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tatca#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tatca extends androidx.fragment.app.Fragment {
    SanPhamBanChayDAO sanPhamBanChayDAO;
    ArrayList<SanPhamBanChay> sanPhamBanChayArrayList;
    public static Tatca newInstance() {
        Tatca fragment = new Tatca();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tatca, container, false);
    }

    RecyclerView recyclerView;
    GioHangDAO gioHangDAO;
    Button btn_dh;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_dh = view.findViewById(R.id.btn_dathang);
        recyclerView = view.findViewById(R.id.rv_giohang);
        gioHangDAO = new GioHangDAO(getContext());
        gioHangDAO.open();
//        GioHang objGH1 = new GioHang(1, "Sản phẩm 1", 3, 15000);
//        gioHangDAO.insert(objGH1);
//        GioHang objGH2 = new GioHang(2, "Sản phẩm 2", 4, 12000);
//        gioHangDAO.insert(objGH2);
//        GioHang objGH3 = new GioHang(3, "Sản phẩm 1", 5, 25000);
//        gioHangDAO.insert(objGH3);
        ArrayList<GioHang> list = gioHangDAO.selectAll2();
        LichSuDAO lichSuDAO = new LichSuDAO(getContext());
        lichSuDAO.open();
        sanPhamBanChayDAO = new SanPhamBanChayDAO(getActivity());
        sanPhamBanChayDAO.open();
        sanPhamBanChayArrayList = sanPhamBanChayDAO.selectAll();
        GioHangAdapter gioHangAdapter = new GioHangAdapter(list, gioHangDAO);
        recyclerView.setAdapter(gioHangAdapter);
        btn_dh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Caidat.nguoimuaLogin!=null){
                    String a = "";
                    int b = 0;
                    for (int i = 0; i<list.size(); i++){
                        a = a + list.get(i).getTensp() +" x "+list.get(i).getSoluong()+"\n";
                        b = b + list.get(i).getDongia();
                    }
                    for (GioHang gioHang : list){
                        for (SanPhamBanChay sp : sanPhamBanChayArrayList){
                            if (gioHang.getTensp().equals(sp.getTensp())){
                                sp.setSoLuong(sp.getSoLuong()+1);
                                sanPhamBanChayDAO.update(sp);
                            }
                        }
                    }
                    Lichsu objLS = new Lichsu();
                    objLS.setTensp(a);
                    objLS.setDongia(b);
                    lichSuDAO.insert(objLS);
                    gioHangDAO.deleteAll();
                    list.clear();
                    recyclerView.setAdapter(gioHangAdapter);
                    Toast.makeText(getContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Xin vui lòng đăng nhập trước khi đặt hàng");
                    builder.setIcon(R.drawable.ic_baseline_insert_emoticon_24);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
//                    builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
                    builder.show();
                }

//                Lichsu objLS = new Lichsu();
//                objLS.setTensp(a);
//                objLS.setDongia(b);
//                lichSuDAO.insert(objLS);
////                Intent sms = new Intent(Intent.ACTION_VIEW);
////                sms.setData(Uri.parse("smsto:"));
////                sms.setType("vnd.android-dir/mms-sms");
////                sms.putExtra("address", new String("0123456789"));
////                sms.putExtra("sms_body", a + b);
////                startActivity(sms);
////                SmsManager smsManager = SmsManager.getDefault();
////                smsManager.sendTextMessage("012345678", null, a + b, null, null);
//                gioHangDAO.deleteAll();
//                list.clear();
//                Toast.makeText(getContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}