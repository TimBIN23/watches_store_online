package com.main.watchesstoreonline.controllers;

import android.content.Context;
import android.content.SharedPreferences;

import com.main.watchesstoreonline.models.Login;

public class LoginAdapter {
    private static final String PREF_NAME = "LoginPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_REMEMBER_ME = "rememberMe";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public LoginAdapter(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLoginDetails(Login loginModel) {
        editor.putString(KEY_EMAIL, loginModel.getEmail());
        editor.putString(KEY_PASSWORD, loginModel.getPassword());
        editor.putBoolean(KEY_REMEMBER_ME, loginModel.isRememberMe());
        editor.apply();
    }

    public Login getSavedLoginDetails() {
        String email = sharedPreferences.getString(KEY_EMAIL, "");
        String password = sharedPreferences.getString(KEY_PASSWORD, "");
        boolean rememberMe = sharedPreferences.getBoolean(KEY_REMEMBER_ME, false);
        return new Login(email, password, rememberMe);
    }

    public void clearLoginDetails() {
        editor.clear();
        editor.apply();
    }

    public boolean isRememberMeChecked() {
        return sharedPreferences.getBoolean(KEY_REMEMBER_ME, false);
    }
}
