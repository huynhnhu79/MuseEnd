package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DathangActivity extends AppCompatActivity {
    ImageView imvBackOrder;
    Button btnPT_vc,btnPT_tt, btnDathang;
    TextView txtHtvc, txtHthtt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_hang);
        linkViews();
        getData();
        addEvents();
    }



    private void linkViews() {
        imvBackOrder= findViewById(R.id.imvBackOrder);
        btnPT_vc= findViewById(R.id.btnPt_vc);
        btnPT_tt= findViewById(R.id.btnPt_tt);
        btnDathang= findViewById(R.id.btnDathang);
        txtHtvc= findViewById(R.id.txtHthvc);
        txtHthtt= findViewById(R.id.txtHthtt);
    }

    private void addEvents() {
        imvBackOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),GiohangActivity.class);
                startActivity(intent);
            }
        });

        btnPT_vc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển sang màn hình vận chuyển
                Intent intent= new Intent(getApplicationContext(),PTVanChuyenActivity.class);
                startActivity(intent);
            }
        });

        btnPT_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển sang màn hình thanh toán
                Intent intent= new Intent(getApplicationContext(),PTThanhToanActivity.class);
                startActivity(intent);
            }
        });

        btnDathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DathangActivity.this, "Bạn đã đặt hàng thành công!", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        //Lấy dữ liệu phương thức vận chuyển
        Intent intent= getIntent();
        String tenPTVC= intent.getStringExtra("tenPTVC");
        //lấy dữ liệu phương thức thanh toán
        String tenPTTT= intent.getStringExtra("tenPTTT");
// Nhận dữ liệu từ 2 phương thức trên
        txtHtvc.setText(tenPTVC);
        txtHthtt.setText(tenPTTT);




    }
}
