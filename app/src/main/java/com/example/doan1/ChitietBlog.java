package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChitietBlog extends AppCompatActivity {
    ImageView imvchitiet;
    TextView txtmota, txttieude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_blog);
        linkView();
        addEvent();
        
    }



    private void linkView() {
        imvchitiet = findViewById(R.id.imvchitiet);
        txtmota = findViewById(R.id.txtmota);
        txttieude = findViewById(R.id.txttieude);


    }
    private void addEvent() {

        Intent intent= getIntent();
        int hinhanhbaiviet= intent.getIntExtra("hinhanhbaiviet",0);
        String mota= intent.getStringExtra("mota");
        String tieude= intent.getStringExtra("tieude");
        imvchitiet.setImageResource(hinhanhbaiviet);
        txttieude.setText(tieude);
        txtmota.setText(mota);


    }
}