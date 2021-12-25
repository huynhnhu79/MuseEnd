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

public class PTThanhToanActivity extends AppCompatActivity {
    Button btnBackThanhtoan, btnThanhtoan;
    RadioGroup rg_PTTT;
    RadioButton radioButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanhtoan);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackThanhtoan= findViewById(R.id.btnBackThanhtoan);
        btnThanhtoan= findViewById(R.id.btnThanhToan);
        rg_PTTT= findViewById(R.id.rg_PTTT);
    }

    private void addEvents() {
        rg_PTTT.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                //i trả về id của radio button
                switch (i) {
                    case R.id.rd_cod:
                        Toast.makeText(PTThanhToanActivity.this, "Bạn đã chọn phương thức thanh toán COD", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rd_ewallet:
                        Toast.makeText(PTThanhToanActivity.this, "Bạn đã chọn phương thức thanh toán ví điện tử", Toast.LENGTH_SHORT).show();
                        break;
                    case  R.id.rd_card:
                        Toast.makeText(PTThanhToanActivity.this, "Bạn đã chọn hình thức thanh toán qua thẻ tín dụng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = rg_PTTT.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                Intent intent= new Intent(getApplicationContext(),DathangActivity.class);
                intent.putExtra("tenPTTT",radioButton.getText().toString());
                startActivity(intent);
            }
        });
    }
}
