package com.rahulkumar.soccerinfo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.model.Sport;

import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by rahulkumar on 4/3/18.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.MyViewHolder> {
    private List<Sport> sportList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView summaryTxt, sportTxt;
        private ImageView imageView;
        private ImageButton moreButton;


        public MyViewHolder(View view) {
            super(view);
            summaryTxt = view.findViewById(R.id.sportSummary);
            imageView = view.findViewById(R.id.sportImage);
            sportTxt = view.findViewById(R.id.sportId);
            moreButton = view.findViewById(R.id.imageButton);
        }
    }


    public RecyclerListAdapter(List<Sport> dailyList, Context context) {
        this.sportList = dailyList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lists_frgment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sport data = sportList.get(position);
        ImagePopup imagePopup =new ImagePopup(context);
        imagePopup.setBackgroundColor(Color.BLACK);
        holder.summaryTxt.setText(data.getStrSportDescription());
        holder.sportTxt.setText(data.getStrSport());
        Glide.with(context).load(data.getStrSportThumb()).into(holder.imageView);
        imagePopup.initiatePopupWithGlide(data.getStrSportThumb());
        holder.imageView.setOnClickListener((v)->imagePopup.viewPopup());
        holder.moreButton.setOnClickListener(v -> alertView(data.getStrSportThumb(), data.getStrSport(), data.getStrSportDescription()));
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    private void alertView(String icon, String tittle, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        Glide.with(context)
                .load(icon)
                .thumbnail(.5f)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        dialog.setIcon(resource);
                    }
                });
        dialog.setTitle(tittle)
                .setMessage(message)
                .setPositiveButton("Ok", (dialoginterface, i) -> dialoginterface.dismiss()).show();

    }
}