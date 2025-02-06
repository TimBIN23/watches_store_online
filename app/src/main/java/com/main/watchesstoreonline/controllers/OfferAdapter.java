package com.main.watchesstoreonline.controllers;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.main.watchesstoreonline.R;
import com.main.watchesstoreonline.models.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    private Context context;
    private List<Offer> offerList;

    // Constructor
    public OfferAdapter(Context context, ArrayList<Offer> offerList) {
        this.context = context;
        this.offerList = offerList;
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for individual list items
        View itemView = LayoutInflater.from(context).inflate(R.layout.offer_item, parent, false);
        return new OfferViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferViewHolder holder, int position) {
        // Bind data to the views in the item layout
        Offer offer = offerList.get(position);
        holder.imageView.setImageResource(offer.getImageResId());
        holder.titleTextView.setText(offer.getTitle());
        holder.descriptionTextView.setText(offer.getDescription());
        holder.discountTextView.setText(offer.getDiscount());
    }

    @Override
    public int getItemCount() {
        return offerList.size(); // Return the size of the list
    }

    // ViewHolder class to hold the item view components
    public static class OfferViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView; // Image for the offer
        TextView titleTextView; // Title of the offer
        TextView descriptionTextView; // Description of the offer
        TextView discountTextView; // Discount information

        public OfferViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.offer_image); // ImageView for the offer image
            titleTextView = itemView.findViewById(R.id.offer_title); // TextView for the title
            descriptionTextView = itemView.findViewById(R.id.offer_description); // TextView for the description
            discountTextView = itemView.findViewById(R.id.offer_discount); // TextView for the discount
        }
    }
}

