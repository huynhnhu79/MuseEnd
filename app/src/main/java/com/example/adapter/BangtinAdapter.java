package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.doan1.R;
import com.example.model.Bangtin;

import java.util.ArrayList;

public class BangtinAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<Bangtin> bangtins;

    public BangtinAdapter(Context context, int item_layout, ArrayList<Bangtin> bangtins) {
        this.context = context;
        this.item_layout = item_layout;
        this.bangtins = bangtins;
    }

    @Override
    public int getCount() {
        return bangtins.size();
    }


    @Override
    public Object getItem(int i) {
        return bangtins.get(i);
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
            holder.imvThumb = view.findViewById(R.id.imvThumb);
//            holder.btn_like = view.findViewById(R.id.btn_like);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Bangtin p = bangtins.get(i);
        holder.imvThumb.setImageResource(p.getBangtinThumb());
//        holder.btn_like.setTag(p.getBangtinLike());
        return view;
    }
    private static class ViewHolder {
        ImageView imvThumb;
//        CheckBox btn_like;
    }
}
