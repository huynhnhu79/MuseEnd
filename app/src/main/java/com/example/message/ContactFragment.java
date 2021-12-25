package com.example.message;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doan1.R;

public class ContactFragment extends Fragment{
TextView txtHotline, txtDD1, txtDD2;
ImageView imgHotline, imgDD1, imgDD2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        txtHotline= view.findViewById(R.id.txtHotline);
        txtDD1= view.findViewById(R.id.txtDD1);
        txtDD2= view.findViewById(R.id.txtDD2);
        imgDD1= view.findViewById(R.id.imgDD1);
        imgDD2= view.findViewById(R.id.imgDD2);
        imgHotline= view.findViewById(R.id.imgHotline);
        imgHotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_CALL);
                Uri uri= Uri.parse("tel:"+ txtHotline.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });

        imgDD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_CALL);
                Uri uri= Uri.parse("tel:"+ txtDD1.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });
        imgDD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_CALL);
                Uri uri= Uri.parse("tel:"+ txtDD2.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });
        return view;

    }



    @Override
    public void onStart() {
        super.onStart();
        Log.i("ContactFragment","onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ContactFragment","onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("ContactFragment","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("ContactFragment","onPause");
    }


}