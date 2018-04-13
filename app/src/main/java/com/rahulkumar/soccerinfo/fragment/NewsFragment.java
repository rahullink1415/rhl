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
import com.rahulkumar.soccerinfo.adapter.RecyclerNewsAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.newsModel.Article;
import com.rahulkumar.soccerinfo.model.newsModel.SportsNews;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.GsonRequest;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";
    private RecyclerView recyclerView;
    private RecyclerNewsAdapter newsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LoadToast loadToast;
    private ArrayList<Article> sportsNewsList = new ArrayList<>();


    public NewsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.newsRecyclerId);
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        newsAdapter = new RecyclerNewsAdapter(sportsNewsList, this.getActivity());
        recyclerView.setAdapter(newsAdapter);
        initToast();
        if (AppClass.isNetworkAvailable(this.getActivity())) {
            getNewsData();
        } else {
            Utility.toast(this.getActivity(), "Network UnAvailable please try again !");
            loadToast.error();
        }


        return view;
    }

    private void initToast() {
        loadToast = new LoadToast(this.getActivity());
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(200);
        loadToast.show();
    }

    private void getNewsData() {

        Utility.log(TAG, Constants.NEWS_URL);
        GsonRequest<SportsNews> sportsGsonRequest = new GsonRequest<>(Constants.NEWS_URL, Request.Method.GET, null, SportsNews.class, null,
                response -> {
                    Utility.log(TAG, response.getTotalResults().toString());
                    newsAdapter = new RecyclerNewsAdapter(response.getArticles(), this.getActivity());
                    recyclerView.setAdapter(newsAdapter);
                    newsAdapter.notifyDataSetChanged();
                    loadToast.success();
                }, error -> {
            loadToast.error();
        });
        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(sportsGsonRequest);
    }


}
