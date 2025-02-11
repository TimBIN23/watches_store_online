package com.main.watchesstoreonline;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.main.watchesstoreonline.controllers.BannerAdapter;
import com.main.watchesstoreonline.controllers.CategoryAdapter;
import com.main.watchesstoreonline.controllers.OfferAdapter;
import com.main.watchesstoreonline.controllers.ProductsAdapter;
import com.main.watchesstoreonline.models.BannerItem;
import com.main.watchesstoreonline.models.Category;
import com.main.watchesstoreonline.models.Offer;
import com.main.watchesstoreonline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Initialize categoryRecyclerView
        RecyclerView categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        // Load categories with images and names
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.w1, "Women"));
        categoryList.add(new Category(R.drawable.w2, "Men"));
        categoryList.add(new Category(R.drawable.w3, "Premium"));
        categoryList.add(new Category(R.drawable.w4, "Smart Watch"));
        categoryList.add(new Category(R.drawable.w7, "Offers"));
        categoryList.add(new Category(R.drawable.w5, "Deals"));
        // Create and set the adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryRecyclerView.setAdapter(categoryAdapter);

        // Initialize offersRecyclerView
        RecyclerView offersRecyclerView = findViewById(R.id.offersRecyclerView);

        // Initialize the list of offers
        ArrayList<Offer> offerList = new ArrayList<>();
        offerList.add(new Offer(R.drawable.w7, "Summer Sale", "Up to 50% off on selected watches", "50%"));
        offerList.add(new Offer(R.drawable.w8, "Winter Collection", "Exclusive winter watches", "20%"));
        offerList.add(new Offer(R.drawable.w9, "Flash Sale", "Limited time offer", "30%"));

        // Initialize the adapter
        OfferAdapter offerAdapter = new OfferAdapter(this, offerList);

        // Set the RecyclerView's LayoutManager and Adapter
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        offersRecyclerView.setAdapter(offerAdapter);


        // Initialize bannerViewPager
        ViewPager2 bannerViewPager = findViewById(R.id.bannerViewPager);
        // Create banner list
        ArrayList<BannerItem> bannerList = new ArrayList<>();
        bannerList.add(new BannerItem(R.drawable.banner1, "New Classic", "SAVE UP TO 80% OFF"));
        bannerList.add(new BannerItem(R.drawable.banner2, "On Timex Watches", "FLAT 33% OFF"));
        bannerList.add(new BannerItem(R.drawable.banner3, "Luxury Timepieces", "Exclusive Collection"));
        // Set up adapter
        BannerAdapter bannerAdapter = new BannerAdapter(bannerList);
        bannerViewPager.setAdapter(bannerAdapter);


        // Step 1: Find the RecyclerView by its ID
        RecyclerView productsRecyclerView = findViewById(R.id.productsRecyclerView);
        List<Product> productList = new ArrayList<>();

        // Adding sample products
        productList.add(new Product("Smart Watch", R.drawable.w20, 99, 1999, 2.5f, 39, 50, true));
        productList.add(new Product("Sports Watch", R.drawable.w19, 150, 999, 4f, 50, 30, false));
        productList.add(new Product("KD Watch", R.drawable.w23, 120, 230, 4.7f, 50, 40, true));
        productList.add(new Product("MD Watch", R.drawable.w22, 50, 200, 3f, 50, 10, true));

        ProductsAdapter adapter = new ProductsAdapter(productList);
        productsRecyclerView.setAdapter(adapter);

    }
}