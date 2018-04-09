package com.rahulkumar.soccerinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.activity.DetailNewsActivity;
import com.rahulkumar.soccerinfo.model.newsModel.Article;

import java.util.List;

/**
 * Created by rahulkumar on 4/9/18.
 */

public class RecyclerNewsAdapter extends RecyclerView.Adapter<RecyclerNewsAdapter.MyViewHolder> {
    private List<Article> sportList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mNewsHeading, mNewsTime;
        private AppCompatImageView mNewsImage;


        public MyViewHolder(View view) {
            super(view);
            mNewsHeading = view.findViewById(R.id.newsHeading);
            mNewsImage = view.findViewById(R.id.newsImage);
            mNewsTime = view.findViewById(R.id.newsTime);

        }
    }


    public RecyclerNewsAdapter(List<Article> dailyList, Context context) {
        this.sportList = dailyList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_news_fragment, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article data = sportList.get(position);
        holder.mNewsHeading.setText(data.getTitle());
        holder.mNewsTime.setText(data.getPublishedAt());
        Glide.with(context).load(data.getUrlToImage())
                .thumbnail(.5f)
                .into(holder.mNewsImage);
        holder.itemView.setOnClickListener(v ->
        {
            Intent intent = new Intent(context, DetailNewsActivity.class);
            intent.putExtra("url", data.getUrl());
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }


}