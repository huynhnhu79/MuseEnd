package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PTVanChuyenActivity extends AppCompatActivity {
    Button btnBackDathang, btnVanchuyen;
    RadioGroup rd_PTVC;
    RadioButton radioButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vanchuyen);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackDathang = findViewById(R.id.btnBackDathang);
        btnVanchuyen = findViewById(R.id.btnVanchuyen);
        rd_PTVC = (RadioGroup) findViewById(R.id.rg_PTVC);

    }

    private void addEvents() {
        btnBackDathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),DathangActivity.class);
                startActivity(intent);
            }
        });

        rd_PTVC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                //i: trả id của radionbutton
                switch (i) {
                    case R.id.rd_VCN:
                        Toast.makeText(PTVanChuyenActivity.this, "Bạn đã chọn phương thức vận chuyển nhanh", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rd_GHTK:
                        Toast.makeText(PTVanChuyenActivity.this, "Bạn đã chọn phương thức giao hàng tiết kiệm", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        btnVanchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = rd_PTVC.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                Intent intent = new Intent(PTVanChuyenActivity.this, DathangActivity.class);
                intent.putExtra("tenPTVC", radioButton.getText().toString());


                startActivity(intent);
            }
        });

    }
}

