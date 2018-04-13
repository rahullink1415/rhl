package com.rahulkumar.soccerinfo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.bumptech.glide.request.transition.Transition;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.model.sportsModel.Events;

import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by rahulkumar on 4/4/18.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private List<Events> eventsList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView eventName, gameName, dateTxt, timeTxt;
        private CardView cardClick;

        public MyViewHolder(View view) {
            super(view);
            eventName = view.findViewById(R.id.eventId);
            gameName = view.findViewById(R.id.game);
            dateTxt = view.findViewById(R.id.dateId);
            timeTxt = view.findViewById(R.id.timeId);
            cardClick =view.findViewById(R.id.card_notification);

        }
    }


    public EventsAdapter(List<Events> eventsList, Context context) {
        this.eventsList = eventsList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_notifiction_layout, parent, false);
      itemView.setVisibility(View.VISIBLE);
        itemView.setAlpha(0.0f);
        itemView.setTranslationX(0.0f);
        itemView.animate()
                .setDuration(3000)
                .translationY(itemView.getHeight())
                .alpha(1.0f)
                .setListener(null)
                .start();

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Events events = eventsList.get(position);
        holder.eventName.setText(events.getStrEvent());
        holder.gameName.setText(events.getStrSport());
        holder.dateTxt.setText(events.getStrDate());
        holder.timeTxt.setText(events.getStrTime());
        holder.cardClick.setOnClickListener(v ->
                alertView("", events.getStrEvent(), events.getStrFilename()));

    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    private void alertView(String icon, String tittle, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        Glide.with(context)
                .load(icon)
                .thumbnail(.3f)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        dialog.setIcon(resource);
                        Log.e(TAG, "onResourceReady: " + resource.toString());
                    }
                });
        dialog.setTitle(tittle)
                .setMessage(message)
                .setPositiveButton("Ok", (dialoginterface, i) -> {
                    dialoginterface.dismiss();
                }).show();

    }

}

