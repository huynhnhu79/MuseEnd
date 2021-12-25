package com.example.doan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.Fragment.BangTinFragment;
import com.example.Fragment.HomeFragment;
import com.example.Fragment.TaiKhoanFragment;
import com.example.Fragment.ThongBaoFragment;
import com.example.Fragment.TinNhanFragment;
import com.example.adapter.DanhMucSanPhamAdapter;
import com.example.model.DanhMucSanPham;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity<drawble> extends AppCompatActivity {
    Button btnGiohang;
    ImageView imvDMAo, imvQuan, imvDam, imvVay, imvPhukien, imvKhac;
    GridView gvGoiYSP;
    ArrayList<DanhMucSanPham> danhMucSanPhams;
    DanhMucSanPhamAdapter adapter;
    BottomNavigationView nav_bottom;
    ViewFlipper viewFlipper;
    DrawerLayout drawerLayout;
    Animation in, out;
    int[] arrayBanner={R.drawable.banner1, R.drawable.banner22, R.drawable.banner3, R.drawable.banner3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        loadData();
        initDataSP();
        loadDataSP();
        addEvents();
        initDataBanner();


    }



    private void initDataBanner() {
        for(int i =0;i<arrayBanner.length;i++){
            ImageView imageView= new ImageView(this);
            imageView.setImageResource(arrayBanner[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewFlipper.addView(imageView);
        }
        in= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        out= AnimationUtils.loadAnimation(this,R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

    }


    private void linkViews() {
        btnGiohang= findViewById(R.id.btnGiohang);
        imvDMAo= findViewById(R.id.imvDMAo);
        imvQuan= findViewById(R.id.imvQuan);
        imvDam= findViewById(R.id.imvDam);
        imvVay= findViewById(R.id.imvVay);
        imvPhukien= findViewById(R.id.imvPhukien);
        imvKhac= findViewById(R.id.imvKhac);
        nav_bottom= findViewById(R.id.nav_bottom);
        gvGoiYSP = findViewById(R.id.gvGoiYSP);
        viewFlipper= findViewById(R.id.viewFlipper);
        drawerLayout= findViewById(R.id.drawerlayout);

    }
    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.menuHome:
                    selectedFragment= new HomeFragment();
                    break;
                case R.id.menuBangtin:
                    selectedFragment= new BangTinFragment();
                    break;
                case R.id.menuThongbao:
                    selectedFragment = new ThongBaoFragment();
                    break;
                case  R.id.menuTinnhan:
                    selectedFragment = new TinNhanFragment();
                    break;
                case R.id.menuTaikhoan:
                    selectedFragment = new TaiKhoanFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };





    private void loadData() {

        nav_bottom.setOnNavigationItemSelectedListener(navListener);

    }

    private void initDataSP() {
        danhMucSanPhams = new ArrayList<DanhMucSanPham>();
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
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd1, "Đầm nhún ngực đuôi cá", 450000,"Đặc tính: Nữ tính - Thanh lịch\n" +
                "Chất liệu: Voan\n" +
                "Họa tiết: Hoa\n" +
                "Giá đã bao gồm VAT\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd2, "Đầm cổ yếm", 500000,"Đặc tính: Trẻ trung - Nữ tính\n" +
                "Chất liệu: Voan\n" +
                "Họa tiết: Hoa\n" +
                "Giá đã bao gồm VAT\n"));
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
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama2, "Pijama hồng hạc", 358000,"Phong cách: Giải trí\n" +
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
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.tuitote, "Túi tote", 100000,"Màu sắc: màu đen,trắng\n" +
                "Thành phần: 100% Polyester\n" +
                "Vật liệu: Polyester\n"));

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
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vongcohinhhoc, "Vòng cổ hình", 95000,"Giới tính: Nữ\n" +
                "Vật liệu: Hợp kim\n" +
                "Màu sắc: Vàng\n"));
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

    }
    private void loadDataSP() {
        adapter = new DanhMucSanPhamAdapter(MainActivity.this, R.layout.item_sanpham, danhMucSanPhams);
        gvGoiYSP.setAdapter(adapter);
    }


    private void addEvents() {
        btnGiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),GiohangActivity.class);
                startActivity(intent);
            }
        });

        imvDMAo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, DMAoActivity.class);
                startActivity(intent);
            }
        });

        imvQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, DMQuanActivity.class);
                startActivity(intent);
            }
        });

        imvDam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DMDamActivity.class);
                startActivity(intent);
            }
        });

        imvVay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DMVayActivity.class);
                startActivity(intent);
            }
        });

        imvPhukien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, DMPhuKienActivity.class);
                startActivity(intent);
            }
        });

        imvKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, DMKhacActivity.class);
                startActivity(intent);
            }
        });

        gvGoiYSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getApplicationContext(),ChitietSanPhamActivity.class);
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