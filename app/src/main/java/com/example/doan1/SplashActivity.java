package com.example.doan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loadData();
    }

    private void loadData() {
        if (AppUnti.isNetworkavilable(this)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent= new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }
            },3000);
        } else {
            Toast.makeText(this, "Network disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}