package com.example.message;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.adapter.AdapterListMessage;
import com.example.database.AppDatabase;
import com.example.database.ItemDAO;
import com.example.doan1.R;
import com.example.model.Message;
import com.example.ultils.Constant;
import com.example.ultils.StoreUtils;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    View view;
    EditText edtSend;
    private StorageReference reference = FirebaseStorage.getInstance().getReference();
    public static final int REQUEST_CODE_CAMERA = 456;
    public static final int SELECT_PICTURE = 123;

    private static final int REQUEST_PHOTO_GALLERY = 100;
    private static final int REQUEST_CAPTURE_IMAGE = 110;
    Uri uriImage;
    ImageView imgSend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    AppDatabase database;
    RecyclerView recyclerView;
    ItemDAO itemDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chat, container, false);

        edtSend = view.findViewById(R.id.edtSend);
        imgSend = view.findViewById(R.id.imgSend);
        imgSend.setBackgroundResource(R.drawable.ic_baseline_send_24);
        recyclerView = view.findViewById(R.id.recyclerView);

        database = Room.databaseBuilder(getContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        itemDAO = database.getItemDAO();

        List<Message> items = itemDAO.getItems();
        if (items.size() == 0) {
            Message item = new Message();
            item.setId(1 + "");
            item.setType(1 + "");
            item.setMassage("Xin chào bạn, bạn có cần tư vấn?");

            Message item1 = new Message();
            item1.setId(2 + "");
            item1.setType(2 + "");
            item1.setMassage("Tôi có thắc mắc về kích thước sản phẩm?");
            itemDAO.insert(item);
            itemDAO.insert(item1);
        }

        if (StoreUtils.get(getContext(), Constant.id).equals("") ||
                StoreUtils.get(getContext(), Constant.id).isEmpty()) {
            StoreUtils.save(getContext(), Constant.id, "3");
        }

        AdapterListMessage adapterListMessage = new AdapterListMessage(getContext(), items);
        recyclerView.setAdapter(adapterListMessage);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = (Integer.parseInt(StoreUtils.get(getContext(), Constant.id)) + 1) + "";

                StoreUtils.save(getContext(), Constant.id, id);
                Message item2 = new Message();
                item2.setId(StoreUtils.get(getContext(), Constant.id));
                item2.setType(2 + "");
                String text = edtSend.getText().toString();
                item2.setMassage(text);
                itemDAO.insert(item2);

                List<Message> items = itemDAO.getItems();

                AdapterListMessage adapterListMessage = new AdapterListMessage(getContext(), items);
                recyclerView.setAdapter(adapterListMessage);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                edtSend.setText("");
                List<Message> items1 = itemDAO.getItems();
                recyclerView.smoothScrollToPosition(items1.size());

            }
        });


        return view;
    }


}