package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Fragment.TaiKhoanFragment;

public class TheodoiActivity extends AppCompatActivity{
    ImageButton imvBackAccount;
    Button btnTd, btnTd1, btnTd2, btnTd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_theodoi);
        linkView();
        addEvent();

    }

    private void linkView() {
        imvBackAccount = findViewById(R.id.imvBackAccount);
        btnTd = findViewById(R.id.btnTd);
        btnTd1 = findViewById(R.id.btnTd1);
        btnTd2 = findViewById(R.id.btnTd2);
        btnTd3 = findViewById(R.id.btnTd3);
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
