package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChitietThongbao extends AppCompatActivity {
    ImageView imvNoti;
    TextView txtMota;
    ListView lvThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_thongbao);

        linkView();
        addEvent();

    }


    private void linkView() {
        imvNoti = findViewById(R.id.imvNoti);
        txtMota = findViewById(R.id.txtMota);
        lvThongBao = findViewById(R.id.lvThongBao);


    }
    private void addEvent() {

        Intent intent = getIntent();
        int hinhanh = intent.getIntExtra("hinhanh", 0);
        String mota = intent.getStringExtra("mota");
        imvNoti.setImageResource(hinhanh);
        txtMota.setText(mota);

    }

}