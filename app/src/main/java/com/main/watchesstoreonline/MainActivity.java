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
//package com.main.watchesstoreonline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "LoginPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_REGISTERED_EMAIL = "registeredEmail";
    private static final String KEY_REGISTERED_PASSWORD = "registeredPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Check if user is already logged in
        if (sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)) {
            showMainLayout();
        } else {
            showLoginLayout();
        }
    }

    private void showLoginLayout() {
        setContentView(R.layout.login_item);

        EditText emailEditText = findViewById(R.id.user_email);
        EditText passwordEditText = findViewById(R.id.user_password);
        CheckBox rememberMeCheckBox = findViewById(R.id.remember_me);
        Button loginButton = findViewById(R.id.login_button);
        TextView signUpButton = findViewById(R.id.link_register);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Retrieve stored credentials
            String registeredEmail = sharedPreferences.getString(KEY_REGISTERED_EMAIL, "");
            String registeredPassword = sharedPreferences.getString(KEY_REGISTERED_PASSWORD, "");

            if (email.equals(registeredEmail) && password.equals(registeredPassword)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(KEY_IS_LOGGED_IN, rememberMeCheckBox.isChecked());
                editor.apply();
                showMainLayout();
            } else {
                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // Sign-Up Button Click → Show Register Layout
        signUpButton.setOnClickListener(v -> showSignUpLayout());
    }

    private void showSignUpLayout() {
        setContentView(R.layout.sign_up);

        EditText userName = findViewById(R.id.sign_up_name);
        EditText userEmail = findViewById(R.id.sign_up_email);
        EditText userPassword = findViewById(R.id.sign_up_password);
        Button registerButton = findViewById(R.id.btnRegister);
        Button loginButton = findViewById(R.id.btnLogin);

        registerButton.setOnClickListener(v -> {
            String username = userName.getText().toString().trim();
            String email = userEmail.getText().toString().trim();
            String password = userPassword.getText().toString().trim();

            if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                // Store user credentials in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_REGISTERED_EMAIL, email);
                editor.putString(KEY_REGISTERED_PASSWORD, password);
                editor.apply();

                Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                showLoginLayout();
            } else {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
        loginButton.setOnClickListener(v -> showLoginLayout());
    }

    private void showMainLayout() {
        setContentView(R.layout.activity_main);
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
