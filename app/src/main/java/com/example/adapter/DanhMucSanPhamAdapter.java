package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan1.R;
import com.example.model.DanhMucSanPham;

import java.util.List;

public class DanhMucSanPhamAdapter extends BaseAdapter {
Context context;
int item_gvAo;
List<DanhMucSanPham> sanPhamAoList;

    public DanhMucSanPhamAdapter(Context context, int item_gvAo, List<DanhMucSanPham> sanPhamAoList) {
        this.context = context;
        this.item_gvAo = item_gvAo;
        this.sanPhamAoList = sanPhamAoList;
    }

    @Override
    public int getCount() {
        return sanPhamAoList.size();
    }

    @Override
    public Object getItem(int position) {
        return sanPhamAoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_gvAo, null);
            holder.imvThumbSP = view.findViewById(R.id.imvThumbSP);
            holder.txtnameSP = view.findViewById(R.id.txtNameSP);
            holder.txtPriceSP = view.findViewById(R.id.txtPriceSP);

            view.setTag(holder);


        }else {
            holder = (ViewHolder) view.getTag();

        }
        DanhMucSanPham b = sanPhamAoList.get(position);
        holder.imvThumbSP.setImageResource(b.getProductThumbSP());
        holder.txtnameSP.setText(b.getProductNameSP());
        holder.txtPriceSP.setText(String.valueOf(b.getProductPriceSP()));



        return view;
    }

    public static class ViewHolder{
        ImageView imvThumbSP;
        TextView txtPriceSP, txtnameSP;

    }
}
