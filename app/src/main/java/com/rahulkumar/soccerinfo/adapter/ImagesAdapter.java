package com.rahulkumar.soccerinfo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.model.sportsModel.SportImage;
import com.rahulkumar.soccerinfo.utilty.DynamicImage;

import java.util.List;

/**
 * Created by rahulkumar on 4/4/18.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {
    private List<SportImage> imageList;
    private Context context;

    public ImagesAdapter(List<SportImage> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_sport_images, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SportImage imageUrl = imageList.get(position);
        ImagePopup imagePopup = new ImagePopup(context);
        imagePopup.setBackgroundColor(Color.BLACK);

        Glide.with(context)
                .load(imageUrl.getUrl())
                .into(new ViewTarget<ImageView, Drawable>(holder.imageView) {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        holder.imageView.setImageDrawable(resource);
                    }

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        super.onLoadFailed(errorDrawable);
                        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.ic_broken_image_black_24dp));
                    }
                });
        holder.imageCard.setOnClickListener((v) -> {
            imagePopup.initiatePopupWithGlide(imageUrl.getUrl());
            imagePopup.viewPopup();
        });

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout imageCard;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            imageCard = itemView.findViewById(R.id.image_containerId);

        }
    }
}
