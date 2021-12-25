package com.example.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan1.GiohangActivity;
import com.example.doan1.R;
import com.example.model.Cart;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    private GiohangActivity context;
    private int item_layout;
    private List<Cart> carts;




    public CartAdapter(GiohangActivity context, int item_layout, List<Cart> carts) {
        this.context = context;
        this.item_layout = item_layout;
        this.carts = carts;
    }

    @Override
    public int getCount() {
        return carts.size();
    }

    @Override
    public Object getItem(int position) {
        return carts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view== null){
            holder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(item_layout,null);
        holder.imvThumbSP=view.findViewById(R.id.imvThumbSP);
        holder.txtNameSP= view.findViewById(R.id.txtNameSP);
        holder.txtPriceSP= view.findViewById(R.id.txtPriceSP);
        holder.imgDelete= view.findViewById(R.id.imgDeleteSP);


        view.setTag(holder);
    }else{
        holder= (ViewHolder) view.getTag();
    }
        //Biling data
    Cart c = carts.get(position);
       holder.txtNameSP.setText(c.getCName());
       holder.txtPriceSP.setText(String.valueOf(c.getwPrice()));


        //Convert byte array bit map
    byte[] photo=c.getwThumb();
    Bitmap bitmap= BitmapFactory.decodeByteArray(photo,0, photo.length);
        holder.imvThumbSP.setImageBitmap(bitmap);


 holder.imgDelete.setOnClickListener(new View.OnClickListener() {

    //delete Cart
    @Override
    public void onClick(View v) {
        context.deleteCart(c);
    }
});


        return view;
    }
    private static class ViewHolder{
        ImageView imvThumbSP;
        TextView txtNameSP, txtPriceSP;
ImageButton imgDelete;
    }
}
