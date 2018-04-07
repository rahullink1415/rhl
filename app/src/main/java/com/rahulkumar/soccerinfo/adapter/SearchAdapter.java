package com.rahulkumar.soccerinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.activity.SearchDetailActivity;
import com.rahulkumar.soccerinfo.model.Player;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by rahulkumar on 4/4/18.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<Player> sportList;
    private Context context;


    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView playerName, playerDescription;
        private CircleImageView imageView;
        private CardView cardView;


        MyViewHolder(View view) {
            super(view);
            playerName = view.findViewById(R.id.eventId);
            imageView = view.findViewById(R.id.playerImage);
            playerDescription = view.findViewById(R.id.game);
            cardView =view.findViewById(R.id.searchCard);

        }
    }


    public SearchAdapter(List<Player> dailyList, Context context) {
        this.sportList = dailyList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_player, parent, false);


        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Player data = sportList.get(position);
        holder.playerName.setText(data.getStrPlayer());
        holder.playerDescription.setText(data.getStrDescriptionEN());
        holder.cardView.setOnClickListener((v)->{
            Intent intent =new Intent(context.getApplicationContext(), SearchDetailActivity.class);
            intent.putExtra("player",data);
            context.startActivity(intent);
        });
        Glide.with(context).load(data.getStrCutout()).into(new ViewTarget<CircleImageView, Drawable>(holder.imageView) {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                holder.imageView.setImageDrawable(resource);

            }
            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                holder.imageView.setImageDrawable(context.getDrawable(R.drawable.ic_person_black_24dp));
            }
            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                super.onLoadStarted(placeholder);
                holder.imageView.setImageDrawable(placeholder);
            }
        });


    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }


}
