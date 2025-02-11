package com.main.watchesstoreonline.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.watchesstoreonline.R;
import com.main.watchesstoreonline.models.BannerItem;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private ArrayList<BannerItem> bannerList;

    public BannerAdapter(ArrayList<BannerItem> bannerList) {
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        BannerItem bannerItem = bannerList.get(position); // No need for cast
        holder.bannerImage.setImageResource(bannerItem.getImageRes());
        holder.bannerTitle.setText(bannerItem.getTitle());
        holder.bannerDescription.setText(bannerItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerImage;
        TextView bannerTitle, bannerDescription;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.banner_image);
            bannerTitle = itemView.findViewById(R.id.banner_title);
            bannerDescription = itemView.findViewById(R.id.banner_description);
        }
    }
}
