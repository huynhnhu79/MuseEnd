package com.example.doan1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.CartAdapter;
import com.example.database.CartDatabase;
import com.example.model.Cart;

import java.util.ArrayList;

public class GiohangActivity extends AppCompatActivity {
    ImageView imvBackCart;
    TextView txtTTShopping, txtTotal;
    ListView lvCart;
    Button btnMuahang;
    ArrayList<Cart> carts;
    CartAdapter adapter;
    CartDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        linkViews();
        loadData();
        addEvents();

        db= new CartDatabase(this);

    }




    private void linkViews() {
        imvBackCart= findViewById(R.id.imvBackCart);
        txtTTShopping=findViewById(R.id.txtTTShopping);
        txtTotal= findViewById(R.id.txtTotal);
        lvCart = findViewById(R.id.lvGiohang);
        btnMuahang= findViewById(R.id.btnMuahang);
    }

    private void loadData() {

        adapter = new CartAdapter(GiohangActivity.this, R.layout.item_list_cart, getDataFromDb());
        lvCart.setAdapter(adapter);

    }
    private ArrayList<Cart> getDataFromDb() {
        carts = new ArrayList<>();
        Cursor cursor = ChitietSanPhamActivity.db.getData("SELECT * FROM " + CartDatabase.TBL_NAME);
        carts.clear();
        while (cursor.moveToNext()) {
            carts.add(new Cart(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2), cursor.getBlob(3)));
        }
        cursor.close();
return carts;
    }





    private void addEvents() {

        imvBackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),ChitietSanPhamActivity.class);
                startActivity(intent);
            }
        });

        btnMuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),DathangActivity.class);
                startActivity(intent);
            }
        });

        txtTTShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }






        public void deleteCart(Cart c){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn có muốn xóa sản phẩm này ra khỏi giỏ hàng? ");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.execSql("DELETE FROM " + CartDatabase.TBL_NAME + " WHERE " + CartDatabase.COL_C_ID + " = "+ c.getcId());
                Toast.makeText(GiohangActivity.this, "Bạn đã xóa thành công!", Toast.LENGTH_SHORT).show();
                loadData();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }


}
