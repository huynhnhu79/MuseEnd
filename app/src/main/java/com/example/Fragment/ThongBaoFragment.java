package com.example.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.adapter.AdapterThongBao;
import com.example.doan1.ChitietBlog;
import com.example.doan1.ChitietThongbao;
import com.example.doan1.DMAoActivity;
import com.example.doan1.DMDamActivity;
import com.example.doan1.GiohangActivity;
import com.example.doan1.MainActivity;
import com.example.doan1.MessageActivity;
import com.example.doan1.R;
import com.example.model.Thongbao;

import java.util.ArrayList;

public class ThongBaoFragment extends Fragment {
    ListView lvThongBao;
    ArrayList<Thongbao> thongbaos;
    AdapterThongBao adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_thong_bao, container, false);
        lvThongBao = view.findViewById(R.id.lvThongBao);
        adapter = new AdapterThongBao(getContext(), R.layout.item_thongbao,initData());
        lvThongBao.setAdapter(adapter);



        lvThongBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    Intent intent= new Intent(getContext(), ChitietBlog.class);
                    int hinh = thongbaos.get(position).getHinh();
                    String mota = thongbaos.get(position).getMota();

                    intent.putExtra("mota",mota);
                    intent.putExtra("hinhanh",hinh);
                    startActivity(intent);
                }else if(position==1) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }else if(position==2){
                    Intent intent= new Intent(getContext(), ChitietBlog.class);
                    int hinh = thongbaos.get(position).getHinh();
                    String mota = thongbaos.get(position).getMota();

                    intent.putExtra("mota",mota);
                    intent.putExtra("hinhanh",hinh);
                    startActivity(intent);
                }else if(position==3){
                    Intent intent = new Intent(getContext(), DMAoActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getContext(), DMDamActivity.class);
                    startActivity(intent);
                }


            }

        });
        return view;
    }

    private ArrayList<Thongbao> initData(){
        thongbaos = new ArrayList<>();
        thongbaos.add(new Thongbao("Cảm ơn bạn đã mua hàng của Muse. Xin gửi bạn Voucher giảm giá 20% cho lần mua tiếp theo.\n" + "Mã giảm giá: KH123456",R.drawable.ic_like));
        thongbaos.add(new Thongbao("Giỏ hàng của bạn đang trống. Hãy tiếp tục tìm kiếm và mua sắm sản phẩm bạn muốn nào",R.drawable.ic_baseline_cart));
        thongbaos.add(new Thongbao("Đơn hàng mã số HC569249 của bạn đang trên đường được vận chuyển đến.\n" + "Vui lòng chú ý điện thoại nhé! Trong qua trình vận chuyển Muse sẽ luôn cập nhật tình hình đơn hàng cho bạn.",R.drawable.ic_baseline_local_shipping_24));
        thongbaos.add(new Thongbao("Bộ sưu tập áo Cozzi sẽ ra mắt vào 25/12/2021.\n" + "Nhấp vô đây để xem chi tiết.",R.drawable.ic_ao2));
        thongbaos.add(new Thongbao("Sale up to 30% cho bộ sưu tập Sweetie vào Noel này.\n" + "Mua ngay nào!",R.drawable.ic_baseline_sale_off));

        return thongbaos;

    }

}
