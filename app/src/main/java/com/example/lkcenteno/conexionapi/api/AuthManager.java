package com.example.lkcenteno.conexionapi.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AuthManager {


    @SuppressLint("StaticFieldLeak")
    private static AuthManager INSTANCE;

    private static final String PREFS_NAME = "AUTH_PREFS";
    private static final String TOKEN_TYPE = "TOKEN_TYPE";
    private static final String EXPIRES_IN = "EXPIRES_IN";
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String REFRESH_TOKEN = "REFRESH_TOKEN";
    private static final String EMAIL = "EMAIL";

    private boolean isLoggedIn = false;
    private Context context;
    private final SharedPreferences authPrefs;

    public static AuthManager get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AuthManager(context);
        }
        INSTANCE.context = context;
        return INSTANCE;
    }

    private AuthManager(Context context) {
        authPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        isLoggedIn = !TextUtils.isEmpty(authPrefs.getString(ACCESS_TOKEN, null));
    }


    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token_type", Objects.requireNonNull(authPrefs.getString("TOKEN_TYPE", "")));
        map.put("expires_in", authPrefs.getInt("EXPIRES_IN", 0));
        map.put("access_token", Objects.requireNonNull(authPrefs.getString("ACCESS_TOKEN", "")));
        map.put("refresh_token", Objects.requireNonNull(authPrefs.getString("REFRESH_TOKEN", "")));
        map.put("email", Objects.requireNonNull(authPrefs.getString("EMAIL", "")));
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(map);
        return data.get(0);
    }

}
