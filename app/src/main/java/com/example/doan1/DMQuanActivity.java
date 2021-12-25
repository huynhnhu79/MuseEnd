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

public class DMQuanActivity extends AppCompatActivity {
    ImageView imvBackHome;
    GridView gvDMQuan;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    DanhMucSanPhamAdapter quanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmquan);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        gvDMQuan= findViewById(R.id.gvDMQuan);
        imvBackHome= findViewById(R.id.imvBackHome);
    }

    private void initData() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai1, "Quần dài thắt dây", 350000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Kiểu: Ống thẳng\n" +
                "Vòng eo: Vòng eo cao + Dây lưng\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 88% Polyester, 10% Sợi viscose, 2% Bông vải thun\n" +
                "Co giãn: Không\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai2, "Quần ống loe ", 300000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Kiểu: Ống loe\n" +
                "Vòng eo: Vòng eo cao \n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 88% Polyester, 10% Sợi viscose, 2% Bông vải thun\n" +
                "Co giãn: Không\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai3, "Quần ống xẻ lai", 370000, "Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Kiểu: Ống loe\n" +
                "Vòng eo: Vòng eo cao \n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 94% Polyester, 6% Bông vải thun\n" +
                "Co giãn: Không\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai4, "Quần linen rộng", 400000,"Màu sắc: Màu be\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Kiểu: Ống rộng\n" +
                "Vòng eo: Vòng eo cao/nút/dây lưng\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Linen\n" +
                "Thành phần: 100% Linen\n" +
                "Co giãn: Không\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai5, "Quần jean rộng", 300000,"Màu sắc: Màu jean sáng\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Kiểu: Ống rộng\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Jeans\n" +
                "Thành phần: 100% Jean\n" +
                "Co giãn: Ít co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quanngan1, "Quần short da", 420000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu:Quần ống rộng\n" +
                "Chi tiết: Túi\n" +
                "Vòng eo: Eo co giãn\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Chất liệu da PU\n" +
                "Thành phần: 50% Polyester, 45% Polyurethane, 5% Bông vải thun\n" +
                "Co giãn: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt khô\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quanngan2, "Quần short kaki", 230000,"Màu sắc: Màu kaki\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu:Quần ống rộng\n" +
                "Chi tiết: Túi\n" +
                "Vòng eo: Dây kéo\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Kaki\n" +
                "Thành phần: Kaki\n" +
                "Co giãn: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quanngan3, "Quần short jeans", 300000,"Màu sắc: Màu trắng\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu:Quần ống vừa\n" +
                "Chi tiết: Túi\n" +
                "Vòng eo: Dây kéo\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Jean\n" +
                "Thành phần: Jean\n" +
                "Co giãn: Ít co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quanngan4, "Quần nhung tăm", 300000,"Màu sắc: Màu kaki\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu:Quần ống rộng\n" +
                "Chi tiết: Túi\n" +
                "Vòng eo: Dây kéo\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Nhung tăm\n" +
                "Thành phần: 97% Polyester, 3% Bông vải thun\n" +
                "Co giãn: Ít co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quanngan5, "Quần short lửng", 450000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu:Quần ống rộng\n" +
                "Chi tiết: Túi\n" +
                "Vòng eo: Nút/ Dây kéo\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Chất liệu da PU\n" +
                "Thành phần: 50% Polyester, 45% Polyurethane, 5% Bông vải thun\n" +
                "Co giãn: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt khô\n"));

    }

    private void loadData() {
        quanAdapter = new DanhMucSanPhamAdapter(DMQuanActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvDMQuan.setAdapter(quanAdapter);
    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DMQuanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gvDMQuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DMQuanActivity.this,ChitietSanPhamActivity.class);
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