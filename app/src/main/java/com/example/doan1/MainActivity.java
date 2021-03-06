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
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac3, "??o kho??c zip", 400000,"M??u s???c: M??u x??m\n" +
                "Ki???u m???u: M??u tr??n\n" +
                "Chi???u d??i: Th?????ng\n" +
                "M??a: M??a Thu/ M??a ????ng\n" +
                "Chi ti???t: D??y k??o\n" +
                "Form: R???ng\n" +
                "Chi???u d??i tay:\tTay ??o d??i\n" +
                "Lo???i tay ??o: Th?????ng\n" +
                "M???ng:\tKh??ng\n" +
                "V???t li???u: L??ng c???u\n" +
                "Th??nh ph???n: 100% B??ng\n" +
                "S???i v???i: Co gi??n nh???\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay/ Gi???t m??y\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.aokhoac4, "??o kho??c l???ng", 400000,"M??u s???c: M??u kem\n" +
                "Ki???u m???u: M??u tr??n\n" +
                "Chi???u d??i: Th?????ng\n" +
                "M??a: M??a Thu/ M??a ????ng/M??a xu??n\n" +
                "Chi ti???t: N??t\n" +
                "Form: V???a\n" +
                "Chi???u d??i tay:\tTay ??o d??i\n" +
                "Lo???i tay ??o: Th?????ng\n" +
                "M???ng:\tKh??ng\n" +
                "V???t li???u: B??ng\n" +
                "Th??nh ph???n: 100% B??ng\n" +
                "S???i v???i: Co gi??n nh???\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay/ Gi???t m??y\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd1, "?????m nh??n ng???c ??u??i c??", 450000,"?????c t??nh: N??? t??nh - Thanh l???ch\n" +
                "Ch???t li???u: Voan\n" +
                "H???a ti???t: Hoa\n" +
                "Gi?? ???? bao g???m VAT\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.dd2, "?????m c??? y???m", 500000,"?????c t??nh: Tr??? trung - N??? t??nh\n" +
                "Ch???t li???u: Voan\n" +
                "H???a ti???t: Hoa\n" +
                "Gi?? ???? bao g???m VAT\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama1, "Pyjama s???c", 237000,"Phong c??ch: D??? th????ng\n" +
                "M??u s???c: Nhi???u m??u\n" +
                "Ki???u m???u: Ho???t h??nh, L?? th??\n" +
                "Ki???u: B??? qu???n\n" +
                "Vi???n: V??ng c???\n" +
                "Chi???u d??i tay: Ng???n tay\n" +
                "M???ng: Kh??ng\n" +
                "H?????ng d???n B???o qu???n: Machine wash or professional dry clean\n" +
                "V???t li???u: Polyester\n" +
                "Th??nh ph???n: 95% Polyester, 5% Spandex\n" +
                "S???i v???i: C??ng nh???\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.pyjama2, "Pijama h???ng h???c", 358000,"Phong c??ch: Gi???i tr??\n" +
                "M??u s???c: Nhi???u m??u\n" +
                "Ki???u m???u: Chim h???ng h???c\n" +
                "Ki???u: B??? qu???n\n" +
                "Vi???n: V??ng c???\n" +
                "Chi???u d??i tay: Tay ??o d??i\n" +
                "M???ng: Kh??ng\n" +
                "H?????ng d???n B???o qu???n: Machine wash or professional dry clean\n" +
                "V???t li???u: N??? m???ng\n" +
                "Th??nh ph???n: 100% Polyester\n" +
                "S???i v???i: C??ng nh???\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.tuitote, "T??i tote", 100000,"M??u s???c: m??u ??en,tr???ng\n" +
                "Th??nh ph???n: 100% Polyester\n" +
                "V???t li???u: Polyester\n"));

        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai1, "Qu???n d??i th???t d??y", 350000,"M??u s???c: M??u ??en\n" +
                "Ki???u m???u: M??u tr??n\n" +
                "Chi???u d??i: D??i\n" +
                "Ki???u: ???ng th???ng\n" +
                "V??ng eo: V??ng eo cao + D??y l??ng\n" +
                "M???ng:\tKh??ng\n" +
                "V???t li???u: Polyester\n" +
                "Th??nh ph???n: 88% Polyester, 10% S???i viscose, 2% B??ng v???i thun\n" +
                "Co gi??n: Kh??ng\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay/ Gi???t m??y\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.quandai2, "Qu???n ???ng loe ", 300000,"M??u s???c: M??u ??en\n" +
                "Ki???u m???u: M??u tr??n\n" +
                "Chi???u d??i: D??i\n" +
                "Ki???u: ???ng loe\n" +
                "V??ng eo: V??ng eo cao \n" +
                "M???ng:\tKh??ng\n" +
                "V???t li???u: Polyester\n" +
                "Th??nh ph???n: 88% Polyester, 10% S???i viscose, 2% B??ng v???i thun\n" +
                "Co gi??n: Kh??ng\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay/ Gi???t m??y\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan1, "V??y ng???n ??m", 250000,"M??u s???c: M??u xanh\n" +
                "Ki???u m???u: M??u tr??n\n" +
                "Chi???u d??i: Ng???n\n" +
                "M??a: M??a H??\n" +
                "Ki???u: V??y ??m\n" +
                "Chi ti???t: ?????p t??\n" +
                "V??ng eo: V??ng eo cao\n" +
                "M???ng:\tKh??ng\n" +
                "V???t li???u: Polyester\n" +
                "Th??nh ph???n:\t88% Polyester, 12% B??ng v???i thun\n" +
                "S???i v???i:\tCo gi??n\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay/ gi???t m??y\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vayngan2, "V??y tennis da", 310000,"M??u s???c:\tM??u n??u ??en\n" +
                "Ki???u m???u:\tM??u tr??n\n" +
                "Chi???u d??i:\tNg???n\n" +
                "M??a:\tM??a H??\n" +
                "Ki???u:\tX???p ly\n" +
                "Chi ti???t: X???p ly\n" +
                "V??ng eo:V??ng eo cao\n" +
                "M???ng:\tKh??ng\n" +
                "V???t li???u: Da PU\n" +
                "Th??nh ph???n:\t100% Polyurethane\n" +
                "S???i v???i:\tKh??ng co gi??n\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.vongcohinhhoc, "V??ng c??? h??nh", 95000,"Gi???i t??nh: N???\n" +
                "V???t li???u: H???p kim\n" +
                "M??u s???c: V??ng\n"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.phukien10, "M?? bucket tr??n", 220000,"M??u s???c: M??u ??en\n" +
                "S??? l?????ng: 1 m???nh\n" +
                "Th??nh ph???n: 95% Polyester, 5% Spandex\n" +
                "H?????ng d???n B???o qu???n: Gi???t tay\n" +
                "V???t li???u: Polyester"));
        danhMucSanPhams.add(new DanhMucSanPham(R.drawable.phukien7, "B??ng ????", 66000,"M??u s???c: M??u be\n" +
                "Ki???u m???u: m??u tr??n\n" +
                "Phong c??ch: Basic\n" +
                "Ki???u: B??ng ???? C?? b???n\n" +
                "S??? l?????ng: 1 m???nh\n" +
                "V???t li???u: Polyester"));

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