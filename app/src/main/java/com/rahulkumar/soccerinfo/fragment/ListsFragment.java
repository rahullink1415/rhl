package com.rahulkumar.soccerinfo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.ViewPagerAdapter;


public class ListsFragment extends Fragment {
    private static final String TAG = "ListsFragment";
    private ViewPagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    public ListsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lists, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        mViewPager = view.findViewById(R.id.viewPager);
        initViewPager();

        return view;
    }


    private void initViewPager() {
        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new AllSportsFragment(), "All Sports");
        pagerAdapter.addFragment(new NewsFragment(), "Sports News");
        mViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }


}
