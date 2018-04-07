package com.rahulkumar.soccerinfo.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.adapter.ImagesAdapter;
import com.rahulkumar.soccerinfo.adapter.SearchAdapter;
import com.rahulkumar.soccerinfo.adapter.SearchTeamAdapter;
import com.rahulkumar.soccerinfo.constants.Constants;
import com.rahulkumar.soccerinfo.model.League;
import com.rahulkumar.soccerinfo.model.Player;
import com.rahulkumar.soccerinfo.model.Sport;
import com.rahulkumar.soccerinfo.model.SportImage;
import com.rahulkumar.soccerinfo.singleton.QueueSingleton;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends Fragment {
    private static final String TAG = "ImagesFragment";
    private RecyclerView recyclerView;
    private ImagesAdapter imagesAdapter;
    private LoadToast loadToast;
    ArrayList<SportImage> sportImages = new ArrayList<>();
    String url;


    public ImagesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        recyclerView = view.findViewById(R.id.imagesRecyclerId);
        url = Constants.BASE_URL + "lookupleague.php?id=4346";
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        imagesAdapter = new ImagesAdapter(sportImages, this.getActivity());
        recyclerView.setAdapter(imagesAdapter);
        initToast();
        getImagesData(url);
        getSportsImages(Constants.BASE_URL + "all_sports.php");
        getLookUpImages(Constants.BASE_URL + "lookup_all_players.php?id=133604");
        return view;
    }

    private void getImagesData(String url) {
        JsonObjectRequest searchReaquest = new JsonObjectRequest(Request.Method.GET, url, null,
                (response) -> {
                    Utility.log(TAG, url);
                    loadToast.setProgressColor(Color.GREEN);
                    Utility.log(TAG, response.toString());
                    onImagesResponse(response);

                }, error -> {
            loadToast.error();
            Utility.log(TAG, "error " + error.getLocalizedMessage());
        });

        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(searchReaquest);

    }

    private void onImagesResponse(JSONObject response) {
        boolean isNull = true;
        JSONArray jsonArray;
        try {
            jsonArray = response.getJSONArray("leagues");
            Gson gson = new Gson();
            Type playerType = new TypeToken<ArrayList<League>>() {
            }.getType();
            List<League> leagueList = gson.fromJson(String.valueOf(jsonArray), playerType);
            for (League league : leagueList) {
                sportImages.add(new SportImage(league.getStrFanart1()));
                sportImages.add(new SportImage(league.getStrFanart2()));
                sportImages.add(new SportImage(league.getStrFanart3()));
                sportImages.add(new SportImage(league.getStrFanart3()));
                sportImages.add(new SportImage(league.getStrFanart4()));
                sportImages.add(new SportImage(league.getStrBadge()));
                sportImages.add(new SportImage(league.getStrPoster()));
                Utility.log(TAG, "images response " + league.getStrFanart1());
            }
            imagesAdapter.notifyDataSetChanged();
            isNull = false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (isNull) {
            loadToast.error();
        }

    }

    private void initToast() {
        loadToast = new LoadToast(this.getActivity());
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(200);
        loadToast.show();
    }

    private void getSportsImages(String url) {
        loadToast.setProgressColor(Color.GREEN);
        JsonObjectRequest searchReaquest = new JsonObjectRequest(Request.Method.GET, url, null,
                (response) -> {
                    Utility.log(TAG, url);
                    loadToast.setProgressColor(Color.GREEN);
                    Utility.log(TAG, response.toString());
                    onSportImagesResponse(response);

                }, error -> {

            Utility.log(TAG, "error " + error.getLocalizedMessage());
        });

        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(searchReaquest);

    }

    private void onSportImagesResponse(JSONObject response) {

        JSONArray jsonArray;
        try {
            jsonArray = response.getJSONArray("sports");
            Gson gson = new Gson();
            Type sportType = new TypeToken<ArrayList<Sport>>() {
            }.getType();
            List<Sport> sportList = gson.fromJson(String.valueOf(jsonArray), sportType);
            for (Sport sport : sportList) {
                sportImages.add(new SportImage(sport.getStrSportThumb()));
                Utility.log(TAG, "images response " + sport.getStrSportThumb());
            }


            imagesAdapter.notifyDataSetChanged();

            //   Utility.log(TAG, "players response " + playerList.get(0).getStrDescriptionEN());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void getLookUpImages(String url) {
        loadToast.setProgressColor(Color.RED);
        JsonObjectRequest searchReaquest = new JsonObjectRequest(Request.Method.GET, url, null,
                (response) -> {
                    boolean isNull = true;
                    JSONArray jsonArray;
                    try {
                        jsonArray = response.getJSONArray("player");
                        Gson gson = new Gson();
                        Type playerType = new TypeToken<ArrayList<Player>>() {
                        }.getType();
                        List<Player> playerList = gson.fromJson(String.valueOf(jsonArray), playerType);
                        for (Player player : playerList) {
                            sportImages.add(new SportImage(player.getStrFanart1()));
                            sportImages.add(new SportImage(player.getStrFanart2()));
                            sportImages.add(new SportImage(player.getStrFanart3()));
                            sportImages.add(new SportImage(player.getStrFanart3()));
                            sportImages.add(new SportImage(player.getStrFanart4()));
                            sportImages.add(new SportImage(player.getStrCutout()));
                            sportImages.add(new SportImage(player.getStrCutout()));
                            Utility.log(TAG, "images response " + player.getStrFanart1());
                        }
                        imagesAdapter.notifyDataSetChanged();
                        loadToast.success();
                        isNull = false;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (isNull) {
                        loadToast.error();
                    }
                    loadToast.hide();

                }, error -> {
            loadToast.error();
            Utility.log(TAG, "error " + error.getLocalizedMessage());
        });

        QueueSingleton.getInstance(this.getActivity()).addToRequestQueue(searchReaquest);

    }

}
