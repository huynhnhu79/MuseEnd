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

public class DMDamActivity extends AppCompatActivity {
    ImageView imvBackHome;
    GridView gvDMDam;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    DanhMucSanPhamAdapter damAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmdam);
        linkViews();
        initDat();
        loadData();
        addEvents();
    }

    private void linkViews() {
        imvBackHome= findViewById(R.id.imvBackHome);
        gvDMDam= findViewById(R.id.gvDMDam);
    }

    private void initDat() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd1, "Đầm yếm dài", 450000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Yếm\n" +
                "Viền: Cổ V\n" +
                "Chiều dài tay: Không tay\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Độ dày: Vừa phải\n" +
                "Thành phần lót: 100% Polyester\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 79% Polyester, 18% Sợi viscose, 3% Bông vải thun\n" +
                "Sợi vải: Co giãn ít\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy.\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd2, "Đầm hai dây", 500000,"Màu sắc:\tNhiều màu\n" +
                "Phong cách: Thanh lịch\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Xuân/ Mùa Thu\n" +
                "Kiểu: Hai Dây\n" +
                "Kiểu tay: áo hai dây\n" +
                "Chiều dài tay:\tKhông tay\n" +
                "Vòng eo: Tự nhiên\n" +
                "Độ dày: Vừa phải\n" +
                "Chất liệu: Nhung\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải:Co  giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd3, "Đầm oversize", 875000,"Màu sắc:\tMàu xanh lam\n" +
                "Phong cách: Dễ thương\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Xuân/Mùa Hè\n" +
                "Kiểu: Đầm dài\n" +
                "Chi tiết: Viền lá sen\n" +
                "Dáng: Rộng\n" +
                "Cổ áo: Cổ vuông\n" +
                "Loại tay áo: Tay phồng\n" +
                "Chiều dài tay: Ngắn tay\n" +
                "Vòng eo: Thắt lưng thấp\n" +
                "Độ dày: Mỏng\n" +
                "Chất liệu: Polyester\n" +
                "Thành phần: 85% Polyester, 15% Bông\n" +
                "Sợi vải: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt máy/Giặt tay"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd4, "Đầm tay phồng", 450000,"Màu sắc:\tMàu xanh chanh\n" +
                "Phong cách: Thanh lịch\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Xuân/Mùa Hè\n" +
                "Cổ áo: Cổ vuông\n" +
                "Loại tay áo: Tay áo phồng\n" +
                "Chiều dài tay: Ngắn tay\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Độ dày: Vừa phải\n" +
                "Vật liệu: Bông\n" +
                "Thành phần: 100% Bông\n" +
                "Sợi vải: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy."));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd5, "Đầm nhún eo", 600000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Ngang gối\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Cổ áo: Cổ tròn\n" +
                "Loại tay áo: Ống tay áo\n" +
                "Chiều dài tay: Tay áo dài\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Độ dày: Vừa\n" +
                "Vật liệu: Bông\n" +
                "Thành phần: 65% Bông, 35% Polyester\n" +
                "Sợi vải: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd6, "Đầm xẻ tà", 625000,"Màu sắc: Màu đen\n" +
                "Phong cách: Boho\n" +
                "Kiểu mẫu: Hoa\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Hai Dây\n" +
                "Tay áo: Áo hai dây\n" +
                "Chiều dài tay: Không tay\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Độ dày: Mỏng\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Co giãn ít\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd7, "Đầm baby doll", 675000,"Màu sắc: Trắng\n" +
                "Phong cách: Dễ thương\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Xuân/ Mùa Thu\n" +
                "Cổ áo: Cổ tròn\n" +
                "Loại tay áo: Tay phồng nhẹ\n" +
                "Chiều dài tay: Ngắn tay\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Dộ dày: Mỏng\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Co giãn ít\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd8, "Đầm hoa CHIFFON", 520000,"Màu sắc: Hồng\n" +
                "Kiểu mẫu: Họa tiết hoa\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Xuân/ Mùa Thu\n" +
                "Viền: Cổ v\n" +
                "Loại tay áo: Tay thường\n" +
                "Chiều dài tay: Tay áo dài\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Dộ dày: Mỏng\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 65% Bông, 35% Polyester\n" +
                "Sợi vải: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd9, "Đầm yếm da", 615000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Ngắn\n" +
                "Mùa: Mùa Xuân/ Mùa Thu\n" +
                "Kiểu: Yếm\n" +
                "Chiều dài tay: Không tay\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Độ dày: Vừa phải\n" +
                "Chất liệu: Da PU\n" +
                "Thành phần: 50% Bông vải thun, 50% Polyester\n" +
                "Sợi vải: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd10, "Đầm babydoll trơn", 590000,"Màu sắc:Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Ngắn\n" +
                "Mùa: Mùa Xuân/Mùa Hè\n" +
                "Chi tiết: Nút phía trước\n" +
                "Kiểu dáng: Rộng\n" +
                "Cổ áo: Cổ sơmi\n" +
                "Loại tay áo: Tay thường\n" +
                "Chiều dài tay: Tay áo dài\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Độ dày: Vừa\n" +
                "Vật liệu: Bông\n" +
                "Thành phần: 100% Bông\n" +
                "Sợi vải: Không co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt máy/ Giặt tay"));
    }

    private void loadData() {
        damAdapter = new DanhMucSanPhamAdapter(DMDamActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvDMDam.setAdapter(damAdapter);
    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DMDamActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gvDMDam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DMDamActivity.this,ChitietSanPhamActivity.class);
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