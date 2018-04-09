package com.rahulkumar.soccerinfo.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.rahulkumar.soccerinfo.AppClass;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.RecyclerListAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.Sports;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.GsonRequest;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllSportsFragment extends Fragment {
    private static final String TAG = "AllSportsFragment";

    private RecyclerView recyclerView;
    private RecyclerListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LoadToast loadToast;

    public AllSportsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_sports, container, false);
        recyclerView = view.findViewById(R.id.listRecyclerId);

        initToast();
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        if (AppClass.isNetworkAvailable(this.getContext())){
            getSportsListData();
            loadToast.error();

        }else {
            Utility.toast(this.getContext(),"network is unavailable,retry ");
        }


        return view;
    }

    private void getSportsListData() {
        String url = Constants.BASE_URL + "all_sports.php";
        GsonRequest<Sports> sportsGsonRequest = new GsonRequest<>(url, Request.Method.GET, null, Sports.class, null,
                response -> {
                    listAdapter = new RecyclerListAdapter(response.getSports(), this.getActivity());
                    recyclerView.setAdapter(listAdapter);
                    loadToast.success();
                }, error -> {
            loadToast.error();
        });
        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(sportsGsonRequest);
    }

    private void initToast() {
        loadToast = new LoadToast(this.getActivity());
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(150);
        loadToast.show();
    }
}