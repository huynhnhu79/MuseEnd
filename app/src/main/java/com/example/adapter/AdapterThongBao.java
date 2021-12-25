package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan1.R;
import com.example.model.Bangtin;
import com.example.model.Thongbao;

import java.util.ArrayList;

public class AdapterThongBao extends BaseAdapter {

    Context context;
    int item_layout;
    ArrayList<Thongbao> thongbaos;

    public AdapterThongBao(Context context, int item_layout, ArrayList<Thongbao> thongbaos) {
        this.context = context;
        this.item_layout = item_layout;
        this.thongbaos = thongbaos;
    }


    @Override
    public int getCount() {
        return thongbaos.size();
    }

    @Override
    public Object getItem(int i) {
        return thongbaos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(item_layout, null);
            holder.imvNoti = view.findViewById(R.id.imvNoti);
            holder.txtMota = view.findViewById(R.id.txtMota);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Thongbao p = thongbaos.get(i);
        holder.imvNoti.setImageResource(p.getHinh());
        holder.txtMota.setText(p.getMota());

        return view;
    }
    private static class ViewHolder {
        ImageView imvNoti;
        TextView txtMota;

    }
}
