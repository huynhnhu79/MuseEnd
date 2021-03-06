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
        thongbaos.add(new Thongbao("C???m ??n b???n ???? mua h??ng c???a Muse. Xin g???i b???n Voucher gi???m gi?? 20% cho l???n mua ti???p theo.\n" + "M?? gi???m gi??: KH123456",R.drawable.ic_heart));
        thongbaos.add(new Thongbao("Gi??? h??ng c???a b???n ??ang tr???ng. H??y ti???p t???c t??m ki???m v?? mua s???m s???n ph???m b???n mu???n n??o",R.drawable.ic_baseline_cart));
        thongbaos.add(new Thongbao("\n????n h??ng m?? s??? HC569249 c???a b???n ??ang tr??n ???????ng ???????c v???n chuy???n ?????n.\n" + "\n\nVui l??ng ch?? ?? ??i???n tho???i nh??! Trong qua tr??nh v???n chuy???n Muse s??? lu??n c???p nh???t t??nh h??nh ????n h??ng cho b???n.",R.drawable.ic_baseline_local_shipping_24));
        thongbaos.add(new Thongbao("B??? s??u t???p ??o Cozzi s??? ra m???t v??o 25/12/2021.\n" + "Nh???p v?? ????y ????? xem chi ti???t.",R.drawable.ic_t_shirt));
        thongbaos.add(new Thongbao("Sale up to 30% cho b??? s??u t???p Sweetie v??o Noel n??y.\n" + "Mua ngay n??o!",R.drawable.ic_baseline_sale_off));

        return thongbaos;

    }

}
