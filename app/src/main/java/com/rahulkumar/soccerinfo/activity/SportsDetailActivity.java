package com.rahulkumar.soccerinfo.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.SportAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.sportsModel.AllSports;
import com.rahulkumar.soccerinfo.model.sportsModel.Country;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.GsonRequest;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;

public class SportsDetailActivity extends AppCompatActivity {
    private static final String TAG = "SportsDetailActivity";
    private RecyclerView recyclerView;
    private SportAdapter sportAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Country> countries = new ArrayList<>();
    private LoadToast loadToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("sport"));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        recyclerView = findViewById(R.id.sportRecyclerId);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        sportAdapter = new SportAdapter(countries, this);
        recyclerView.setAdapter(sportAdapter);
        getSportsListData();
    }

    private void getSportsListData() {
        initToast();
        String url = Constants.SPORT_URL + getIntent().getStringExtra("sport");
        GsonRequest<AllSports> sportsGsonRequest = new GsonRequest<>(url, Request.Method.GET, null, AllSports.class, null,
                response -> {
                    sportAdapter = new SportAdapter(response.getCountrys(), this);
                    recyclerView.setAdapter(sportAdapter);
                    Utility.log(TAG,response.getCountrys().get(0).getStrPoster());
                    loadToast.success();
                }, error -> {
            loadToast.error();
            Utility.toast(this, error.getLocalizedMessage());
        });
        QueueSingleton.getInstance(this).addToRequestQueue(sportsGsonRequest);
    }

    private void initToast() {
        loadToast = new LoadToast(this);
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(200);
        loadToast.show();
    }
}
