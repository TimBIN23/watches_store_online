package com.main.watchesstoreonline.controllers;


import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.main.watchesstoreonline.R;
import com.main.watchesstoreonline.models.Product;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> productList;

    public ProductsAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productImage.setImageResource(product.getImageResId());
        holder.productPrice.setText("Rs " + product.getPrice());
//        holder.productOriginalPrice.setText("Rs " + product.getOriginalPrice());
        holder.productOriginalPrice.setPaintFlags(holder.productOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.productRating.setRating(product.getRating());
        holder.reviewCount.setText("(" + product.getReviewCount() + " Reviews)");
        holder.discountBadge.setText(product.getDiscount() + "%");

        holder.wishlistIcon.setImageResource(product.isWishlisted() ? R.drawable.ic_heart_filled : R.drawable.ic_heart_outline);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage, wishlistIcon;
        TextView productName, productPrice, productOriginalPrice, reviewCount, discountBadge;
        RatingBar productRating;
        Button shopNowButton;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            wishlistIcon = itemView.findViewById(R.id.wishlistIcon);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productOriginalPrice = itemView.findViewById(R.id.productOriginalPrice);
            // Apply strike-through to the original price
            productRating = itemView.findViewById(R.id.productRating);
            reviewCount = itemView.findViewById(R.id.reviewCount);
            discountBadge = itemView.findViewById(R.id.discountBadge);
            shopNowButton = itemView.findViewById(R.id.shopNowButton);
        }
    }
}
