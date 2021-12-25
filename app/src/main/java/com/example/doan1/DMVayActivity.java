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

public class DMVayActivity extends AppCompatActivity {
ImageView imvBackHome;
    GridView gvDMVay;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    DanhMucSanPhamAdapter vayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmvay);
        linkViews();
        initData();
        loadData();
        addEvents();
    }



    private void linkViews() {
        imvBackHome= findViewById(R.id.imvBackHome);
        gvDMVay= findViewById(R.id.gvDMVay);
    }



    private void initData() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan1, "Váy ngắn ôm", 250000,"Màu sắc: Màu xanh\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Ngắn\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Váy ôm\n" +
                "Chi tiết: Đắp tà\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần:\t88% Polyester, 12% Bông vải thun\n" +
                "Sợi vải:\tCo giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan2, "Váy tennis da", 310000,"Màu sắc:\tMàu nâu đen\n" +
                "Kiểu mẫu:\tMàu trơn\n" +
                "Chiều dài:\tNgắn\n" +
                "Mùa:\tMùa Hè\n" +
                "Kiểu:\tXếp ly\n" +
                "Chi tiết: Xếp ly\n" +
                "Vòng eo:Vòng eo cao\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Da PU\n" +
                "Thành phần:\t100% Polyurethane\n" +
                "Sợi vải:\tKhông co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan3, "Váy ngắn xếp ly", 350000,"Màu sắc: Màu nâu đen\n" +
                "Kiểu mẫu: Màu trơn\n" +
                "Chiều dài: Ngắn\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Xếp ly\n" +
                "Chi tiết: Xếp ly, Túi\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 79% Polyester, 18% Sợi viscose, 3% Bông vải thun\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan4, "Váy ngắn ôm xẻ đùi", 280000,"Màu sắc: Màu đen\n" +
                "Kiểu mẫu:  Màu trơn\n" +
                "Chiều dài: Ngắn\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Xẻ đùi\n" +
                "Chi tiết: Xẻ 2 bên, có lót trong\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 72% Polyester, 28% Bông vải thun\n" +
                "Sợi vải: Co giãn\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan5, "Váy ngắn họa tiết", 350000,"Màu sắc: Màu trắng/ Đen\n" +
                "Kiểu mẫu: Họa tiết\n" +
                "Chiều dài: Ngắn\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Chữ A\n" +
                "Chi tiết: Không\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng:\tKhông\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần:\t75% Polyester, 15% Sợi viscose, 10% Bông vải thun\n" +
                "Sợi vải: Co giãn nhẹ\n" +
                "Hướng dẫn Bảo quản: Giặt tay/ giặt máy\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vd1, "Váy hoa", 250000,"Phong cách: Boho\n" +
                "Màu sắc:\tNhiều màu\n" +
                "Kiểu mẫu:\tHọa tiết hoa\n" +
                "Chiều dài:\tDài\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu: Một Line\n" +
                "Chi tiết: Dây kéo\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Không căng\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vd2, "Váy dài thắt rút", 310000,"Phong cách: Giải trí\n" +
                "Màu sắc: Cà phê nâu\n" +
                "Kiểu mẫu:\tmàu trơn\n" +
                "Chiều dài:\tNgắn\n" +
                "Mùa: Mùa Thu/ Mùa Đông\n" +
                "Kiểu: Một Line\n" +
                "Chi tiết: Viên lá sen\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng: Không\n" +
                "Vật liệu: vải to sợi\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Không căng\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vd3, "Váy ôm co giãn", 350000,"Phong cách: Thanh lịch\n" +
                "Màu sắc: màu đen\n" +
                "Kiểu mẫu:\tmàu trơn\n" +
                "Chiều dài:\tDài\n" +
                "Mùa: Mùa Xuân/Mùa Hè/ Mùa Thu\n" +
                "Kiểu: Bút chì\n" +
                "Chi tiết: Chia\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng: Không\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 97% Polyester, 3% Spandex\n" +
                "Sợi vải: Căng trung bình\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vd4, "Váy dài xẻ đùi", 280000,"Phong cách: Hấp dẫn\n" +
                "Màu sắc: Màu Đỏ Sâu\n" +
                "Kiểu mẫu:\tmàu trơn\n" +
                "Chiều dài:\tNgắn\n" +
                "Mùa: TẤT CẢ\n" +
                "Kiểu: eo hẹp\n" +
                "Vòng eo:\tVòng eo cao\n" +
                "Mỏng: Không\n" +
                "Vải lót: Không có đường viền\n" +
                "Vật liệu: Xa ten\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Không căng\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vd5, "Váy dài họa tiết", 350000,"Phong cách: Giải trí\n" +
                "Màu sắc:\tmàu đen\n" +
                "Kiểu mẫu:\tmàu trơn\n" +
                "Chiều dài:\tNgắn\n" +
                "Mùa: Mùa Hè\n" +
                "Kiểu: Xếp li\n" +
                "Chi tiết: Xếp li\n" +
                "Vòng eo: Vòng eo cao\n" +
                "Mỏng: Không\n" +
                "Vải lót: Không có đường viền\n" +
                "Vật liệu: chất liệu da PU\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Căng nhẹ\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean"));

    }
    private void loadData() {
        vayAdapter = new DanhMucSanPhamAdapter(DMVayActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvDMVay.setAdapter(vayAdapter);

    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DMVayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gvDMVay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DMVayActivity.this,ChitietSanPhamActivity.class);
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