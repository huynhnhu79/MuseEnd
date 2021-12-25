package com.example.doan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.MyDatabaseHelper;

public class EnterResetMKActivity extends AppCompatActivity {
ImageView imvBackLogin1;
TextView txtusername;
EditText edtResetMK, edtNhapresetMk;
Button btnXacnhan;
MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_reset_mkactivity);
        linkViews();
        addEvents();
        loadData();
    }


    private void linkViews() {
        imvBackLogin1= findViewById(R.id.imvBackLogin1);
        txtusername= findViewById(R.id.txtusername3);
        edtResetMK= findViewById(R.id.edtresetMK);
        edtNhapresetMk= findViewById(R.id.edtNhapresetMK);
        btnXacnhan= findViewById(R.id.btnXacnhan);
        db= new MyDatabaseHelper(this);
    }

    private void loadData() {
        Intent intent= getIntent();
        txtusername.setText(intent.getStringExtra("username"));
    }

    private void addEvents() {
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= txtusername.getText().toString();
                String pass= edtResetMK.getText().toString();
                String repass= edtNhapresetMk.getText().toString();

                if(pass.equals(repass))
                {
                    Boolean checkpasswordupdate = db.updatepassword(user,pass);
                    if(checkpasswordupdate== true){
                        Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(EnterResetMKActivity.this, "Cập nhật mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(EnterResetMKActivity.this, "Cập nhật mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(EnterResetMKActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}