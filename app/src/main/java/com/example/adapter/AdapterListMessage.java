package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan1.R;
import com.example.model.Message;
import com.example.ultils.Constant;

import java.util.List;

public class AdapterListMessage extends RecyclerView.Adapter<AdapterListMessage.Viewholider> {
    Context context;
    List<Message> list;

    public AdapterListMessage(Context context, List<Message> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Constant.right) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_right, parent, false);
            Viewholider viewHolder = new Viewholider(view);
            return viewHolder;
        } else {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_left, parent, false);
            Viewholider viewHolder = new Viewholider(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholider holder, int position) {
        Message chatResponse = list.get(position);
        holder.txtText.setText(chatResponse.getMassage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholider extends RecyclerView.ViewHolder {
        TextView txtText;

        public Viewholider(@NonNull View itemView) {
            super(itemView);
            txtText = itemView.findViewById(R.id.txtGetMessage);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType().equals("2")) {
            return Constant.right;
        } else {
            return Constant.left;
        }
    }
}