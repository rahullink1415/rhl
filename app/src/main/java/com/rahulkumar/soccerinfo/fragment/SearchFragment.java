package com.rahulkumar.soccerinfo.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rahulkumar.soccerinfo.AppClass;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.SearchAdapter;
import com.rahulkumar.soccerinfo.adapter.SearchTeamAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.CommanModel;
import com.rahulkumar.soccerinfo.model.sportsModel.Player;
import com.rahulkumar.soccerinfo.model.sportsModel.Teams;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchFragment extends Fragment {
    private static final String TAG = "SearchFragment";
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private SearchTeamAdapter searchTeamAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LoadToast loadToast;
    private TextView searchTxt;
    private ArrayList<Teams> teamsArrayList;
    ArrayList<Player> playerList = new ArrayList<>();

    public SearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.searchRecyclerId);
        layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        searchTxt = view.findViewById(R.id.searchTxt);
        getPlayerSearchData("https://www.thesportsdb.com/api/v1/json/1/lookup_all_players.php?id=133604");
        ImageButton searchButton = view.findViewById(R.id.searchButtonImg);
        final String[] url = new String[2];
        initRadioGroup(view, url);
        searchButton.setOnClickListener(v -> {
            if (url[0] != null) {

                if (!Objects.equals(url[0], "")) {
                    if (AppClass.isNetworkAvailable(this.getActivity())) {
                        getTeamSearchData(url[0] + searchTxt.getText());
                    } else {
                        Utility.toast(this.getActivity(), "Network UnAvailable please try again !");
                       // loadToast.error();
                    }

                } else if (Objects.equals(url[0], "")) {

                    if (AppClass.isNetworkAvailable(this.getActivity())) {
                        getPlayerSearchData(url[1] + searchTxt.getText());
                    } else {
                        Utility.toast(this.getActivity(), "Network UnAvailable please try again !");
                        //loadToast.error();
                    }
                }
            } else {
                Utility.toast(this.getActivity(), "select one option below");
            }


        });
        return view;
    }

    private void getTeamSearchData(String url) {
        Utility.log(TAG, "teamSearch " + url + searchTxt.getText());
        initToast();
        JsonObjectRequest searchRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                (response) -> {
                    Utility.log(TAG, response.toString());
                    onTeamSearch(response);

                }, error -> {
            loadToast.error();
            Utility.toast(getContext(), "error " + error.getLocalizedMessage());
        });

        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(searchRequest);

    }

    private void getPlayerSearchData(String url) {
        Utility.log(TAG, "playerSearch " + url + searchTxt.getText());
        //String finalUrl =url+searchTxt.getText();
        initToast();
        JsonObjectRequest searchRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                (response) -> {
                    Utility.log(TAG, response.toString());
                    onPlayerSearch(response);

                }, error -> {
            loadToast.error();
            Utility.toast(getContext(), "error " + error.getLocalizedMessage());
        });

        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(searchRequest);

    }

    private void onTeamSearch(JSONObject response) {
        boolean isNull = true;
        try {
            JSONArray jsonArrayTeams = response.getJSONArray("teams");
            Gson gson = new Gson();
            Type teamType = new TypeToken<ArrayList<Teams>>() {
            }.getType();
            if (searchAdapter != null && teamsArrayList != null) {
                teamsArrayList.clear();
                searchAdapter.notifyDataSetChanged();
            }
            loadToast.setProgressColor(Color.GREEN);
            teamsArrayList = gson.fromJson(String.valueOf(jsonArrayTeams), teamType);
            searchTeamAdapter = new SearchTeamAdapter(teamsArrayList, this.getActivity());
            recyclerView.setAdapter(searchTeamAdapter);
            searchTeamAdapter.notifyDataSetChanged();
            loadToast.success();
            isNull = false;
            Utility.log(TAG, "teams response " + teamsArrayList.get(0).getStrDescriptionEN());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (isNull) {
            loadToast.error();
            Utility.toast(this.getContext(), "No team found");
        }
        loadToast.hide();

    }

    private void onPlayerSearch(JSONObject response) {
        boolean isNull = true;
        JSONArray jsonArray;
        try {
            jsonArray = response.getJSONArray("player");
            Gson gson = new Gson();
            Type playerType = new TypeToken<ArrayList<Player>>() {
            }.getType();
            playerList = gson.fromJson(String.valueOf(jsonArray), playerType);
            searchAdapter = new SearchAdapter(playerList, this.getActivity());
            recyclerView.setAdapter(searchAdapter);
            searchAdapter.notifyDataSetChanged();
            loadToast.success();
            isNull = false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (isNull) {
            loadToast.error();
            Utility.toast(this.getContext(), "No player found");
        }
        loadToast.hide();

    }

    private void initToast() {
        loadToast = new LoadToast(this.getActivity());
        loadToast.setText("searching..");
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(500);
        loadToast.show();
    }

    private void initRadioGroup(View view, String[] url) {

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (searchTxt.getText() != null) {
                switch (checkedId) {
                    case R.id.teamNameId:
                        url[0] = Constants.BASE_URL + "searchteams.php?t=";
                        break;
                    case R.id.playerTeamId:
                        url[0] = "";
                        url[1] = Constants.BASE_URL + "searchplayers.php?t=";

                        break;
                    case R.id.playerNameId:
                        url[0] = "";
                        url[1] = Constants.BASE_URL + "searchplayers.php?p=";
                        break;

                }
            }

        });
    }
}
