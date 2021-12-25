package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.DanhMucSanPhamAdapter;
import com.example.model.DanhMucSanPham;

import java.util.ArrayList;

public class DMPhuKienActivity extends AppCompatActivity {
    ImageView imvBackHome;
    GridView gvDMPhukien;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    DanhMucSanPhamAdapter phukienAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmphu_kien);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        imvBackHome= findViewById(R.id.imvBackHome);
        gvDMPhukien= findViewById(R.id.gvDMPhukien);

    }

    private void initData() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.tuivaiden1, "Túi vải đen", 100000,"Phong cách: Sẵn sàng\n" +
                "Màu sắc: trắng\n" +
                "Kiểu mẫu: Lá thư\n" +
                "Kiểu: Túi mua sắm\n" +
                "Loại dây đeo: Đôi tay cầm\n" +
                "Vật liệu: Bông\n" +
                "Kích thước túi: Lớn\n" +
                "Thành phần: 100% Bông\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.phukien9, "Nơ kẹp tóc", 79000,"Phong cách: Ngọt ngào\n" +
                "Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Số lượng: 1 mảnh\n" +
                "Chi tiết: Nơ Bướm\n" +
                "Kiểu: Kẹp Pháp\n" +
                "Vật liệu: Voan"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.phukien10, "Mũ bucket trơn", 220000,"Màu sắc: Màu đen\n" +
                "Số lượng: 1 mảnh\n" +
                "Thành phần: 95% Polyester, 5% Spandex\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n" +
                "Vật liệu: Polyester"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.phukien7, "Băng đô", 66000,"Màu sắc: Màu be\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Phong cách: Basic\n" +
                "Kiểu: Băng đô Cơ bản\n" +
                "Số lượng: 1 mảnh\n" +
                "Vật liệu: Polyester"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.nhanbac, "Nhẫn bạc", 250000,"Giới tính: Nữ\n" +
                "Màu sắc: Bạc\n" +
                "Vật liệu: Hợp kim\n" +
                "Đường kính: 1.8\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.phukien6, "Kẹp trái tim", 119000,"Phong cách: Giải trí\n" +
                "Màu sắc: Vàng\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Số lượng: 1 mảnh\n" +
                "Kiểu: Kẹp tóc Lớn\n" +
                "Vật liệu: Hợp kim"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.tuitote, "Túi tote trắng", 125000,"Màu sắc: màu đen,trắng\n" +
                "Thành phần: 100% Polyester\n" +
                "Vật liệu: Polyester\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vongcohinhhoc, "Vòng cổ hình", 95000,"Giới tính: Nữ\n" +
                "Vật liệu: Hợp kim\n" +
                "Màu sắc: Vàng\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vongtay, "Vòng tay vàng", 125000,"Giới tính: Nữ\n" +
                "Màu sắc: Vàng\n" +
                "Vật liệu: Hợp kim\n" +
                "Số lượng: chiếc\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.bongtai, "Bông tay bạc", 99000,"Giới tính: Nữ\n" +
                "Vật liệu: Hợp kim\n" +
                "Màu sắc: Bạc\n" +
                "Số lượng: chiếc\n"));


    }

    private void loadData() {
        phukienAdapter = new DanhMucSanPhamAdapter(DMPhuKienActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvDMPhukien.setAdapter(phukienAdapter);
    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DMPhuKienActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gvDMPhukien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DMPhuKienActivity.this,ChitietSanPhamActivity.class);
                int hinht = danhMucSanPhams.get(position).getProductThumbSP();
                String tent = danhMucSanPhams.get(position).getProductNameSP();
                double giat= danhMucSanPhams.get(position).getProductPriceSP();
                String motat = danhMucSanPhams.get(position).getProductDetailSPSP();
                intent.putExtra("hinhanhsanpham",hinht);
                intent.putExtra("tensanpham",tent);
                intent.putExtra("giasanpham",giat);
                intent.putExtra("motasanpham",motat);

                startActivity(intent);
            }
        });
    }
}