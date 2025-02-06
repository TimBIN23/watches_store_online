package com.main.watchesstoreonline;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.main.watchesstoreonline.controllers.CategoryAdapter;
import com.main.watchesstoreonline.controllers.OfferAdapter;
import com.main.watchesstoreonline.models.Category;
import com.main.watchesstoreonline.models.Offer;

import java.util.ArrayList;

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

    }
}