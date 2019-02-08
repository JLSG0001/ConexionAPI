package com.example.lkcenteno.conexionapi.api;

import android.content.Context;

import com.example.lkcenteno.conexionapi.BuildConfig;
import com.example.lkcenteno.conexionapi.api.interceptors.AuthInterceptor;
import com.example.lkcenteno.conexionapi.api.interceptors.HeaderInterceptor;
import com.example.lkcenteno.conexionapi.api.interceptors.NetworkConnectionInterceptor;
import com.example.lkcenteno.conexionapi.api.service.ApiBeacons;
import com.google.gson.Gson;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private Context context;

    public ApiManager(Context context) {
        this.context = context;
    }

    private Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(provideOkHttpClient())
                .build();
    }



    private OkHttpClient provideOkHttpClient() {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(60, TimeUnit.SECONDS);
        client.readTimeout(60, TimeUnit.SECONDS);
        client.writeTimeout(60, TimeUnit.SECONDS);

        // Para debug

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(httpLoggingInterceptor);
        }

        // fin debug

        // Interceptores
        client.addInterceptor(new NetworkConnectionInterceptor(context));
        client.addInterceptor(new HeaderInterceptor(context));
        client.addInterceptor(new AuthInterceptor(context));


        return client.build();
    }



    private static String getBaseUrl() {
        return BuildConfig.BASE_URL;
    }

/*
    public ApiService getApiService() {
        return provideRetrofit().create(ApiService.class);
    }
    */

    public ApiBeacons getApiBeacons (){
        return provideRetrofit().create(ApiBeacons.class);
    }
}

