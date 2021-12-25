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

public class DMKhacActivity extends AppCompatActivity {
    ImageView imvBackHome;
    GridView gvDMKhac;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    DanhMucSanPhamAdapter khacAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmkhac);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        imvBackHome= findViewById(R.id.imvBackHome);
        gvDMKhac= findViewById(R.id.gvDMKhac);

    }

    private void initData() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama1, "Pyjama sọc", 237000,"Phong cách: Dễ thương\n" +
                "Màu sắc: Nhiều màu\n" +
                "Kiểu mẫu: Hoạt hình, Lá thư\n" +
                "Kiểu: Bộ quần\n" +
                "Viền: Vòng cổ\n" +
                "Chiều dài tay: Ngắn tay\n" +
                "Mỏng: Không\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 95% Polyester, 5% Spandex\n" +
                "Sợi vải: Căng nhẹ\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama2, "Pijama chim hồng", 358000,"Phong cách: Giải trí\n" +
                "Màu sắc: Nhiều màu\n" +
                "Kiểu mẫu: Chim hồng hạc\n" +
                "Kiểu: Bộ quần\n" +
                "Viền: Vòng cổ\n" +
                "Chiều dài tay: Tay áo dài\n" +
                "Mỏng: Không\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean\n" +
                "Vật liệu: Nỉ mỏng\n" +
                "Thành phần: 100% Polyester\n" +
                "Sợi vải: Căng nhẹ\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama3, "Pijama màu trơn", 431000,"Phong cách: Giải trí\n" +
                "Màu sắc: Màu Khaki\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Kiểu: Bộ quần\n" +
                "Viền: Vòng cổ\n" +
                "Chiều dài tay: Tay áo dài\n" +
                "Mỏng: Không\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 92% Polyester, 8% Bông vải thun\n" +
                "Sợi vải: Căng trung bình\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama4, "Pijama bông", 293000,"Phong cách: Giải trí\n" +
                "Màu sắc: trắng\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Mùa: Mùa Thu/ Mùa Đông\n" +
                "Kiểu: Bộ quần\n" +
                "Số lượng các mảnh: Bộ 2 miếng\n" +
                "Viền: Dây\n" +
                "Chiều dài tay: Không tay\n" +
                "Mỏng: Không\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean\n" +
                "Vật liệu: Nỉ mõng\n" +
                "Thành phần: 65% Polyester, 35% Bông\n" +
                "Sợi vải: Căng cao\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama5, "Pyjama họa tiết", 309000,"Phong cách: Giải trí\n" +
                "Màu sắc: Nhiều màu\n" +
                "Kiểu mẫu: Nhiệt đới\n" +
                "Kiểu: Bộ quần\n" +
                "Chi tiết: Tương phản ràng buộc, Nút phía trước\n" +
                "Viền: Cổ áo tây\n" +
                "Chiều dài tay: Ngắn tay\n" +
                "Mỏng: Không\n" +
                "Hướng dẫn Bảo quản: Machine wash or professional dry clean\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 97% Polyester, 3% Bông vải thun\n" +
                "Sợi vải: Không căng\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.bikibi1, "Bộ bikini nữ", 236000,"Màu sắc: Màu vàng\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Viền: áo hai dây\n" +
                "Loại áo ngực: áo lót không có vòng thép\n" +
                "Các Loại Bottom: Vòng eo cao\n" +
                "Vải lót: Lót\n" +
                "Pad ngực: Đệm  có thể tháo rời\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 82% Polyester, 18% Bông vải thun\n" +
                "Sợi vải: Căng nhẹ\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.bikini2, "Bikini dây chéo", 294000,"Phong cách: Gợi cảm\n" +
                "Màu sắc: Cà phê nâu\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Chi tiết: Dây kéo\n" +
                "Viền: Dây\n" +
                "Loại áo ngực: áo lót không có vòng thép\n" +
                "Các Loại Bottom: Váy, Cắt Cao\n" +
                "Vải lót: Vâng\n" +
                "Pad ngực: Đệm  có thể tháo rời\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean\n" +
                "Vật liệu: Nylon\n" +
                "Thành phần: 80% Nylon, 20% Bông vải thun\n" +
                "Sợi vải: Căng cao\n" +
                " \n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.bikini3, "Bikini chữ V", 245000,"Màu sắc: màu đen\n" +
                "Kiểu mẫu: Sọc\n" +
                "Chi tiết: Dòng V\n" +
                "Viền: Cổ v\n" +
                "Loại áo ngực: áo lót không có vòng thép\n" +
                "Các Loại Bottom: Vòng eo cao\n" +
                "Vải lót: Lót\n" +
                "Pad ngực: Đệm  có thể tháo rời\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean\n" +
                "Vật liệu: Nylon\n" +
                "Thành phần: 80% Polyamide, 20% Bông vải thun\n" +
                "Sợi vải: Căng cao\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.bikini4, "Tankinis nữ", 233000,"Phong cách: Thể thao\n" +
                "Màu sắc: trắng\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Chi tiết: Ren lên\n" +
                "Viền: Dây\n" +
                "Loại áo ngực: áo lót không có vòng thép\n" +
                "Các Loại Bottom: Quần short\n" +
                "Vải lót: Lót\n" +
                "Pad ngực: Đệm  có thể tháo rời\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean\n" +
                "Vật liệu: Polyester\n" +
                "Thành phần: 82% Polyester, 18% Bông vải thun\n" +
                "Sợi vải: Căng cao\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.bikini5, "Đồ bơi liền thân", 271000,"Số lượng các mảnh: Bộ 3 miếng\n" +
                "Phong cách: Thể thao\n" +
                "Màu sắc: màu đen\n" +
                "Kiểu mẫu: màu trơn\n" +
                "Chi tiết: Thắt nút\n" +
                "Viền: Dây\n" +
                "Loại áo ngực: Tam giác\n" +
                "Các Loại Bottom: Vòng eo cao, Cắt Cao\n" +
                "Pad ngực: Đệm  có thể tháo rời\n" +
                "Hướng dẫn Bảo quản: Machine wash, do not dry clean\n" +
                "Vật liệu: Nylon\n" +
                "Thành phần: 82% Polyester, 18% Spandex\n" +
                "Sợi vải: Căng cao\n" +
                "\n"));
    }

    private void loadData() {
        khacAdapter = new DanhMucSanPhamAdapter(DMKhacActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvDMKhac.setAdapter(khacAdapter);
    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DMKhacActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gvDMKhac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DMKhacActivity.this,ChitietSanPhamActivity.class);
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