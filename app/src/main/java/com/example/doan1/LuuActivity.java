package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Fragment.TaiKhoanFragment;

public class LuuActivity  extends AppCompatActivity{
    ImageButton imvBackAccount;
    Button btnbv_01, btnbv_02,btnbv_03,btnbv_04,btnbv_05,btnbv_06,btnbv_07,btnbv_08,btnbv_09,btnbv_10,btnbv_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_luubaiviet);
        linkView();
        addEvent();

    }

    private void linkView() {
        imvBackAccount = findViewById(R.id.imvBackAccount);
        btnbv_01 = findViewById(R.id.btnbv_01);
        btnbv_02 = findViewById(R.id.btnbv_02);
        btnbv_03 = findViewById(R.id.btnbv_03);
        btnbv_04 = findViewById(R.id.btnbv_04);
        btnbv_05 = findViewById(R.id.btnbv_05);
        btnbv_06 = findViewById(R.id.btnbv_06);
        btnbv_07 = findViewById(R.id.btnbv_07);
        btnbv_08 = findViewById(R.id.btnbv_08);
        btnbv_09 = findViewById(R.id.btnbv_09);
        btnbv_10 = findViewById(R.id.btnbv_10);
        btnbv_11 = findViewById(R.id.btnbv_11);

    }

    private void addEvent() {
        imvBackAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển sang màn hình Account
                Intent intent = new Intent(getApplicationContext(), TaiKhoanFragment.class);
                startActivity(intent);
            }
        });
    }
}
