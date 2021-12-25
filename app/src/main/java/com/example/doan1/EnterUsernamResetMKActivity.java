package com.example.doan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.database.MyDatabaseHelper;

public class EnterUsernamResetMKActivity extends AppCompatActivity {
ImageView imvBacklogin;
EditText edtusername2;
Button btnTieptuc;
MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_usernam_reset_mkactivity);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        imvBacklogin= findViewById(R.id.imvBackLogin);
        edtusername2= findViewById(R.id.edtusername2);
        btnTieptuc= findViewById(R.id.btnTieptuc);
        db= new MyDatabaseHelper(this);
    }

    private void addEvents() {
        imvBacklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user= edtusername2.getText().toString();

                Boolean checkuser = db.checkusername(user);
                if(checkuser== true)
                {
                    Intent intent = new Intent(getApplicationContext(),EnterResetMKActivity.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(EnterUsernamResetMKActivity.this, "Tài khoản không tồn tại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}