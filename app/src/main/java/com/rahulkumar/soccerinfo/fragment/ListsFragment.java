package com.rahulkumar.soccerinfo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.RecyclerListAdapter;
import com.rahulkumar.soccerinfo.adapter.ViewPagerAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.Sports;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.GsonRequest;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;


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
