package com.example.doan1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.CartDatabase;

import java.io.ByteArrayOutputStream;

public class ChitietSanPhamActivity extends AppCompatActivity {
    TextView txtNameSP, txtPriceSP, txtDetailSP;
    ImageView imvThumSP, imvBackDMAo;
    Button btnAddGiohang;

    public static CartDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_san_pham);
        linkViews();
        addEvents();

        db= new CartDatabase(this);
    }



    private void linkViews() {
        imvThumSP= findViewById(R.id.imvThumbSP);
        imvBackDMAo= findViewById(R.id.imvBackDMAo);
        txtNameSP= findViewById(R.id.txtNameSP);
        txtPriceSP= findViewById(R.id.txtPriceSP);
        txtDetailSP= findViewById(R.id.txtDetailSP);
        btnAddGiohang= findViewById(R.id.btnAddGiohang);
    }

    private void addEvents() {

        imvBackDMAo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ChitietSanPhamActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //lấy dữ liệu
        Intent intent= getIntent();
        int hinhanhsanpham= intent.getIntExtra("hinhanhsanpham",0);
        String tensanpham= intent.getStringExtra("tensanpham");
        double giasanpham= intent.getDoubleExtra("giasanpham",0);
        String motasanpham= intent.getStringExtra("motasanpham");

        imvThumSP.setImageResource(hinhanhsanpham);
        txtNameSP.setText(tensanpham);
        txtPriceSP.setText(String.valueOf(giasanpham));
        txtDetailSP.setText(motasanpham);


        btnAddGiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert data
                String name;
                double price;
                name= txtNameSP.getText().toString();
                price= Double.parseDouble(txtPriceSP.getText().toString());
                if(!name.equals("") && price != 0){
                    boolean flag= db.insertData(name, price, convertPhoto());
                    if(flag){
                        Toast.makeText(ChitietSanPhamActivity.this, "Thêm vào giỏ hàng thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),GiohangActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(ChitietSanPhamActivity.this, "Thất bại!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private byte[] convertPhoto() {
        BitmapDrawable drawable = (BitmapDrawable)  imvThumSP.getDrawable();
        Bitmap bitmap= drawable.getBitmap();
        ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        return  outputStream.toByteArray();
    }


}