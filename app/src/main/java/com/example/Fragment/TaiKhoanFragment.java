package com.example.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.doan1.CaidatchungActivity;
import com.example.doan1.LoginActivity;
import com.example.doan1.LuuActivity;
import com.example.doan1.QuanlyActivity;
import com.example.doan1.R;
import com.example.doan1.TheodoiActivity;
import com.example.doan1.ThongtinActivity;


public class TaiKhoanFragment extends Fragment {
    Button btnTtcn,btnQldh,btnL,btnTdct,btnCdc,btnDx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        btnTtcn = (Button) view.findViewById(R.id.btnTtcn);
        btnQldh = (Button) view.findViewById(R.id.btnQldh);
        btnL = (Button) view.findViewById(R.id.btnL);
        btnTdct = (Button) view.findViewById(R.id.btnTdct);
        btnCdc = (Button) view.findViewById(R.id.btnCdc);
        btnDx = (Button) view.findViewById(R.id.btnDx);



        btnTtcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ThongtinActivity.class);
                startActivity(intent);
            }
        });

        btnQldh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuanlyActivity.class);
                startActivity(intent);
            }
        });

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LuuActivity.class);
                startActivity(intent);
            }
        });
        btnTdct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TheodoiActivity.class);
                startActivity(intent);
            }
        });

        btnCdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaidatchungActivity.class);
                startActivity(intent);
            }
        });

        btnDx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        return view;

    }

}