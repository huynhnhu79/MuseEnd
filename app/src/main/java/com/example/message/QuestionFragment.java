package com.example.message;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.doan1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LinearLayout linearLayoutText1, linearLayoutText2, linearLayoutText3;
    View view;

    public QuestionFragment() {
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
    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Button btnChinhSach, btnHinhThuc, btnTrangThai;
    boolean check = true;
    View view1;
    View view2;
    View view3;
    ImageView imgBack;
    TextView txtText1, txtText2,txtText3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_question, container, false);

        // anh xa
        linearLayoutText1 = view.findViewById(R.id.linearLayoutText1);
        linearLayoutText2 = view.findViewById(R.id.linearLayoutText2);
        linearLayoutText3 = view.findViewById(R.id.linearLayoutText3);
        btnChinhSach = view.findViewById(R.id.btnChinhSach);
        imgBack = view.findViewById(R.id.imgBack);
        view1 = view.findViewById(R.id.view1);
        view2 = view.findViewById(R.id.view2);
        view3 = view.findViewById(R.id.view3);
        btnHinhThuc = view.findViewById(R.id.btnHinhThuc);
        btnTrangThai = view.findViewById(R.id.btnTrangThai);
        txtText1 = view.findViewById(R.id.txtText1);
        txtText2 = view.findViewById(R.id.txtText2);
        txtText3 = view.findViewById(R.id.txtText3);

        btnChinhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check) {
                    ViewGroup.LayoutParams params = linearLayoutText1.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    linearLayoutText1.setLayoutParams(params);
                    imgBack.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    btnHinhThuc.setVisibility(View.GONE);
                    btnTrangThai.setVisibility(View.GONE);
                    txtText1.setVisibility(View.VISIBLE);
                    check = false;
                } else {
                    imgBack.setVisibility(View.GONE);
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.VISIBLE);
                    btnHinhThuc.setVisibility(View.VISIBLE);
                    btnTrangThai.setVisibility(View.VISIBLE);
                    btnChinhSach.setVisibility(View.VISIBLE);
                    check = true;
                    ViewGroup.LayoutParams params = linearLayoutText1.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = 0;
                    linearLayoutText1.setLayoutParams(params);
                    txtText1.setVisibility(View.GONE);
                }
            }
        });
        btnHinhThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check) {
                    ViewGroup.LayoutParams params = linearLayoutText2.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    linearLayoutText2.setLayoutParams(params);
                    imgBack.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    view3.setVisibility(View.GONE);
                    btnChinhSach.setVisibility(View.GONE);
                    btnHinhThuc.setVisibility(View.VISIBLE);
                    btnTrangThai.setVisibility(View.GONE);
                    txtText1.setVisibility(View.GONE);
                    txtText2.setVisibility(View.VISIBLE);
                    txtText3.setVisibility(View.GONE);
                    check = false;
                } else {
                    imgBack.setVisibility(View.GONE);
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.VISIBLE);
                    view3.setVisibility(View.VISIBLE);
                    btnHinhThuc.setVisibility(View.VISIBLE);
                    btnTrangThai.setVisibility(View.VISIBLE);
                    btnChinhSach.setVisibility(View.VISIBLE);
                    check = true;
                    ViewGroup.LayoutParams params = linearLayoutText2.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = 0;
                    linearLayoutText2.setLayoutParams(params);
                    txtText2.setVisibility(View.GONE);
                }
            }
        });
        btnTrangThai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check) {
                    ViewGroup.LayoutParams params = linearLayoutText3.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    linearLayoutText3.setLayoutParams(params);
                    imgBack.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.GONE);
                    view2.setVisibility(View.GONE);
                    view3.setVisibility(View.GONE);
                    btnChinhSach.setVisibility(View.GONE);
                    btnHinhThuc.setVisibility(View.GONE);
                    btnTrangThai.setVisibility(View.VISIBLE);
                    txtText1.setVisibility(View.GONE);
                    txtText2.setVisibility(View.GONE);
                    txtText3.setVisibility(View.VISIBLE);
                    check = false;
                } else {
                    imgBack.setVisibility(View.GONE);
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.VISIBLE);
                    view3.setVisibility(View.VISIBLE);
                    btnHinhThuc.setVisibility(View.VISIBLE);
                    btnTrangThai.setVisibility(View.VISIBLE);
                    btnChinhSach.setVisibility(View.VISIBLE);
                    check = true;
                    ViewGroup.LayoutParams params = linearLayoutText3.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = 0;
                    linearLayoutText3.setLayoutParams(params);
                    txtText3.setVisibility(View.GONE);
                }
            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBack.setVisibility(View.GONE);
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.VISIBLE);
                btnHinhThuc.setVisibility(View.VISIBLE);
                btnChinhSach.setVisibility(View.VISIBLE);
                btnTrangThai.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = linearLayoutText1.getLayoutParams();
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                params.width = 0;
                linearLayoutText1.setLayoutParams(params);

                txtText1.setVisibility(View.GONE);
                txtText2.setVisibility(View.GONE);
                txtText3.setVisibility(View.GONE);
            }
        });


        return view;
    }


}