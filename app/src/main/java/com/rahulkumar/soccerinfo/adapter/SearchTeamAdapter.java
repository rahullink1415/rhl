package com.rahulkumar.soccerinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.activity.SearchDetailActivity;
import com.rahulkumar.soccerinfo.model.sportsModel.Teams;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by rahulkumar on 4/4/18.
 */

public class SearchTeamAdapter extends RecyclerView.Adapter<SearchTeamAdapter.MyViewHolder> {
    private List<Teams> sportList;
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
            cardView = view.findViewById(R.id.searchCard);
        }
    }

    public SearchTeamAdapter(List<Teams> dailyList, Context context) {
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
        Teams data = sportList.get(position);
        holder.playerName.setText(data.getStrTeam());
        holder.playerDescription.setText(data.getStrDescriptionEN());
        holder.cardView.setOnClickListener((v) -> {
            Intent intent = new Intent(context.getApplicationContext(), SearchDetailActivity.class);
            intent.putExtra("teams", data);
            context.startActivity(intent);
        });
        Glide.with(context).load(data.getStrTeamBadge()).into(new ViewTarget<CircleImageView, Drawable>(holder.imageView) {

            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                holder.imageView.setImageDrawable(resource);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }


}
