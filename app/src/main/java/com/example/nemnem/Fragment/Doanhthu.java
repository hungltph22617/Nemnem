package com.example.nemnem.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nemnem.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Doanhthu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Doanhthu extends Fragment {

    public static Doanhthu newInstance() {
        Doanhthu fragment = new Doanhthu();
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
        return inflater.inflate(R.layout.fragment_doanhthu, container, false);
    }
}