package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Transaction;

import com.example.Fragment.TaiKhoanFragment;

public class ThongtinActivity extends AppCompatActivity {
       ImageButton imvBackAccount;
       EditText edit_ten, edit_email, edit_ttk, edit_sinhnhat, edit_dc;
       Button btnCapNhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_thongtin_canhan);
        linkView();
        addEvents();



    }

    private void linkView() {
        imvBackAccount = findViewById(R.id.imvBackAccount);
        edit_ten = findViewById(R.id.edit_ten);
        edit_email = findViewById(R.id.edit_email);
        edit_ttk = findViewById(R.id.edit_ttk);
        edit_sinhnhat = findViewById(R.id.edit_sinhnhat);
        edit_dc = findViewById(R.id.edit_dc);
        btnCapNhat = findViewById(R.id.btnCapNhat);

    }


    private void addEvents() {
        imvBackAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển sang màn hình Account
                Intent intent = new Intent(getApplicationContext(), TaiKhoanFragment.class);
                startActivity(intent);
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TaiKhoanFragment.class);
                startActivity(intent);
            }
        });
    }
}
