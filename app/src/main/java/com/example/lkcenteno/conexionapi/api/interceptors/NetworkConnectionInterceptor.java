package com.example.lkcenteno.conexionapi.api.interceptors;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.example.lkcenteno.conexionapi.api.exceptions.UnavailableInternetException;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class NetworkConnectionInterceptor implements Interceptor {

    private Context context;

    public NetworkConnectionInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        if (!isOnline()) {
            throw new UnavailableInternetException(context);
        }
        return chain.proceed(chain.request());
    }

    private boolean isOnline() {
        ConnectivityManager connMgr =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        return (networkInfo != null && networkInfo.isConnected());
    }

}
