package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.DanhMucSanPhamAdapter;
import com.example.model.DanhMucSanPham;

import java.util.ArrayList;

public class DMAoActivity extends AppCompatActivity {
    ImageView imvBackHome;
    GridView gvDMAo;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    ArrayList<DanhMucSanPham> arrayList;
    DanhMucSanPhamAdapter aoAdapter;
    TextView txtNameSP, txtPriceSP, txtDetailSP;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmao);
        linkViews();
        initData();
        loadData();
        addEvents();
    }



    private void prepareDb() {
    }

    private void linkViews() {
        txtNameSP= findViewById(R.id.txtNameSP);
        txtPriceSP= findViewById(R.id.txtPriceSP);
        txtDetailSP= findViewById(R.id.txtDetailSP);
        gvDMAo= findViewById(R.id.gvDMAo);
        imvBackHome= findViewById(R.id.imvBackHome);
    }

    private void initData() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac1, "Áo khoác tweed", 390000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Lửng\n" +
                "Mùa: Mùa Thu/ Mùa Đông\n" +
                "Chi tiết: Nút\n" +
                "Form: Vừa\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Thường\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu:\tTweed \n" +
                "Thành phần:\t65% Bông, 35% Polyester\n" +
                "Sợi vải:\tKhông co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt khô\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.ao1, "Áo thun nâu", 180000,"Màu sắc:\tMàu nâu\n" +
                "Kiểu mẫu:\tSlogan\n" +
                "Chiều dài:\tDài\n" +
                "Mùa:\tMùa Hè\n" +
                "Viền: Cổ tròn\n" +
                "Chiều dài tay:\tNgắn tay\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu:\tBông\n" +
                "Thành phần:\t100% Bông\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac3, "Áo khoác zip", 400000,"Màu sắc: Màu xám\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Thường\n" +
                "Mùa: Mùa Thu/ Mùa Đông\n" +
                "Chi tiết: Dây kéo\n" +
                "Form: Rộng\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Thường\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Lông cừu\n" +
                "Thành phần: 100% Bông\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac4, "Áo khoác lửng", 400000,"Màu sắc: Màu kem\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Thường\n" +
                "Mùa: Mùa Thu/ Mùa Đông/Mùa xuân\n" +
                "Chi tiết: Nút\n" +
                "Form: Vừa\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Thường\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Bông\n" +
                "Thành phần: 100% Bông\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac5, "Áo khoác da lửng", 550000,"Màu sắc: Màu nâu\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Lửng\n" +
                "Mùa: Mùa Thu/ Mùa Đông\n" +
                "Chi tiết: Nút\n" +
                "Form: Rộng\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Thường\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu:\tchất liệu da PU\n" +
                "Thành phần:\tPolyurethane\n" +
                "Sợi vải:\tKhông co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt khô\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokieu1, "Áo kiểu tay phồng", 350000,"Màu sắc: Trắng\n" +
                "Kiểu mẫu: Vân sọc\n" +
                "Mùa:\tMùa Xuân/Mùa Hè\n" +
                "Viền: Cổ cao\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Tay phồng\n" +
                "Chiều dài: Thường\n" +
                "Loại áo: Áo chui cổ\n" +
                "Sợi vải: Không co giãn\n" +
                "Mỏng:\tTrong mờ\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 100% Polyester\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.ao2, "Áo thun California", 180000,"Màu sắc: Màu trắng\n" +
                "Kiểu mẫu: Slogan\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Hè\n" +
                "Viền: Cổ tròn\n" +
                "Chiều dài tay:\tNgắn tay\n" +
                "Mỏng: Mỏng\n" +
                "Vật liệu: Bông\n" +
                "Thành phần: 100% Bông\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac2, "Áo khoác da", 650000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Lửng\n" +
                "Mùa: Mùa Thu/ Mùa Đông\n" +
                "Chi tiết: Dây kéo\n" +
                "Form: Rộng\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Tay áo Đèn lồng\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu:\tchất liệu da PU\n" +
                "Thành phần:\tPolyurethane\n" +
                "Sợi vải:\tKhông co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ Giặt khô\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.ao3, "Áo thun slogan", 190000,"Màu sắc: Màu kem\n" +
                "Kiểu mẫu: Slogan\n" +
                "Chiều dài: Dài\n" +
                "Mùa: Mùa Hè\n" +
                "Viền: Cổ tròn\n" +
                "Chiều dài tay:\tNgắn tay\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Bông\n" +
                "Thành phần: 100% Bông\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokieu2, "Áo khoác ngoài", 380000,"Màu sắc: Nâu\n" +
                "Kiểu mẫu: Họa tiết\n" +
                "Mùa:\tMùa Xuân/Mùa Hè/ Mùa thu/ Mùa đông\n" +
                "Viền: Hai dây\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Tay phồng\n" +
                "Chiều dài: Ngắn\n" +
                "Loại áo: Set 2 áo\n" +
                "Sợi vải: Co giãn\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 100% Polyester\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokieu3, "Áo dệt kim", 290000,"Màu sắc: Kem\n" +
                "Kiểu mẫu: Vân sọc\n" +
                "Mùa:\tMùa Xuân/Mùa Hè\n" +
                "Viền: Cổ cao\n" +
                "Chiều dài tay:\tTay áo dài\n" +
                "Loại tay áo: Tay phồng/ Bo tay\n" +
                "Chiều dài: Thường\n" +
                "Loại áo: Áo chui cổ\n" +
                "Sợi vải: Co giãn\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 72% Polyester, 24% Bông, 4% Bông vải thun\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokieu4, "Áo croptop dài", 200000,"Màu sắc: Trắng\n" +
                "Kiểu mẫu: Trơn\n" +
                "Mùa:\tMùa Xuân/Mùa Hè\n" +
                "Viền: Cổ tròn\n" +
                "Chiều dài tay: Tay áo dài\n" +
                "Loại tay áo: Tay thường\n" +
                "Chiều dài: Ngắn\n" +
                "Loại áo: Áo chui cổ\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Mỏng:\tMỏng\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 92% Polyester, 8% Bông vải thun\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n"));
    }

    private void loadData() {
        aoAdapter = new DanhMucSanPhamAdapter(DMAoActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvDMAo.setAdapter(aoAdapter);
    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DMAoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gvDMAo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DMAoActivity.this,ChitietSanPhamActivity.class);
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