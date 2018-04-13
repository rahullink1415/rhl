package com.rahulkumar.soccerinfo.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.model.sportsModel.Country;
import com.rahulkumar.soccerinfo.model.sportsModel.Player;
import com.rahulkumar.soccerinfo.model.sportsModel.Teams;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchDetailActivity extends AppCompatActivity {
    private static final String TAG = "SearchDetailActivity";
    private CircleImageView circleImageView;
    private TextView mName, mDescription;
    private ImageView mPlayerImg;
    private CollapsingToolbarLayout collapsingToolbar;
    private LoadToast loadToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        circleImageView = findViewById(R.id.circleImageView);
        mName = findViewById(R.id.nameId);
        mDescription = findViewById(R.id.descriptionId);
        mPlayerImg = findViewById(R.id.img_player);
        collapsingToolbar = findViewById(R.id.toolbar_layout);


        Player player = getIntent().getParcelableExtra("player");
        Teams teams = getIntent().getParcelableExtra("teams");
        Country country =getIntent().getParcelableExtra("country");
        if (player != null) {

        setPlayer(player);
        }
        else if (teams != null) {
            setTeams(teams);
        }
        else if (country !=null){
            setCountry(country);
        }
    }
    private void initToast() {
        loadToast = new LoadToast(this);
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(200);
        loadToast.show();
    }
    private void setPlayer(Player player){     Utility.log(TAG, "player " + player.getStrDescriptionEN());
        mName.setText(player.getStrPlayer());
        mDescription.setText(player.getStrDescriptionEN());
        collapsingToolbar.setTitle(player.getStrPlayer());
        initToast();
        Glide.with(this).load(player.getStrCutout()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                circleImageView.setImageDrawable(resource);
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                circleImageView.setImageDrawable(getDrawable(R.drawable.football_jersey));
            }
        });
        Glide.with(this).load(player.getStrThumb()).listener(new RequestListener<Drawable>() {

            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                loadToast.error();
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                loadToast.success();
                return false;
            }
        }).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                mPlayerImg.setImageDrawable(resource);
                loadToast.hide();
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                mPlayerImg.setImageDrawable(getDrawable(R.drawable.ic_football_player));
            }
        });
    }
    private void setTeams(Teams teams){initToast();
        Utility.log(TAG, "teams " + teams.getStrDescriptionEN());
        mName.setText(teams.getStrTeam());
        mDescription.setText(teams.getStrDescriptionEN());
        collapsingToolbar.setTitle(teams.getStrTeam());
        //toolbar.setTitle(teams.getStrTeam());
        Glide.with(this).load(teams.getStrTeamBadge()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                circleImageView.setImageDrawable(resource);
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                circleImageView.setImageDrawable(getDrawable(R.drawable.ic_football_player));
            }
        });
        Glide.with(this).load(teams.getStrStadiumThumb()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                loadToast.error();
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                loadToast.success();
                return false;
            }
        }).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                mPlayerImg.setImageDrawable(resource);
                loadToast.hide();
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                mPlayerImg.setImageDrawable(getDrawable(R.drawable.ic_football_field));
            }
        });
    }
    private void setCountry(Country country){
        Utility.log(TAG, "country " + country.getStrFanart1());
        mName.setText(country.getStrLeague());
        mDescription.setText(country.getStrDescriptionEN());
        collapsingToolbar.setTitle(country.getStrCountry());
        initToast();

        Glide.with(this).load(country.getStrBadge()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                circleImageView.setImageDrawable(resource);
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                circleImageView.setImageDrawable(getDrawable(R.drawable.football_jersey));
            }
        });
        Glide.with(this).load(country.getStrFanart1()).listener(new RequestListener<Drawable>() {

            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                loadToast.error();
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                loadToast.success();
                return false;
            }
        }).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                mPlayerImg.setImageDrawable(resource);
                loadToast.hide();
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                mPlayerImg.setImageDrawable(getDrawable(R.drawable.ic_football_player));
            }
        });
    }
}
