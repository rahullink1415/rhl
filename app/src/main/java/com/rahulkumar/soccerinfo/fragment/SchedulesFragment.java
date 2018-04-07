package com.rahulkumar.soccerinfo.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.EventsAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.Events;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SchedulesFragment extends Fragment {
    private static final String TAG = "SchedulesFragment";
    private RecyclerView recyclerView;
    private EventsAdapter eventsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Events> eventsArrayList = new ArrayList<>();
    private String url;
    private LoadToast loadToast;


    public SchedulesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedules, container, false);
        recyclerView = view.findViewById(R.id.searchRecyclerId);
        url = Constants.BASE_URL + "eventsnextleague.php?id=4328";
        recyclerView =view.findViewById(R.id.eventsRecyclerId);
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        Log.e(TAG, url);
        recyclerView.setLayoutManager(layoutManager);
        eventsAdapter = new EventsAdapter(eventsArrayList, this.getActivity());
        recyclerView.setAdapter(eventsAdapter);
        initToast();
        getSchdeuleData(url);
        return view;
    }

    private void getSchdeuleData(String url) {
        JsonObjectRequest searchReaquest = new JsonObjectRequest(Request.Method.GET, url, null,
                (response) -> {
                    Utility.log(TAG, response.toString());
                    onScheduleResponce(response);
                }, error -> {
            Utility.log(TAG, "error " + error.getLocalizedMessage());
            loadToast.error();
        });

        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(searchReaquest);

    }

    private void onScheduleResponce(JSONObject response) {
        JSONArray jsonArrayEvents;
        try {
            jsonArrayEvents = response.getJSONArray("events");
            Gson gson = new Gson();
            Type eventType = new TypeToken<ArrayList<Events>>() {
            }.getType();
            ArrayList<Events> teamsArrayList = gson.fromJson(String.valueOf(jsonArrayEvents), eventType);
            eventsArrayList.addAll(teamsArrayList);
            eventsAdapter.notifyDataSetChanged();
            loadToast.success();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        loadToast.hide();
    }
    private void initToast(){
        loadToast =new LoadToast(this.getActivity());
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(200);
        loadToast.show();
    }


}
