package com.example.doan1;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Fragment.TaiKhoanFragment;

public class QuanlyActivity extends AppCompatActivity {
    ImageButton imvBackAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_quanlydh);
        linkView();
        addEvent();

    }

    private void linkView() {
        imvBackAccount = findViewById(R.id.imvBackAccount);
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
