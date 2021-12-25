package com.example.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doan1.R;
import com.example.message.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class TinNhanFragment extends Fragment {
    private TabLayout tab_layout;
    private ViewPager mess_viewpager;
    private View mView;


    public TinNhanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_tin_nhan, container, false);

        tab_layout = mView.findViewById(R.id.tab_layout);
        mess_viewpager= mView.findViewById(R.id.mess_viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mess_viewpager.setAdapter(adapter);
        tab_layout.setupWithViewPager(mess_viewpager);

        return mView;

    }
}