package com.example.lkcenteno.conexionapi.api.interceptors;

import android.content.Context;

import com.example.lkcenteno.conexionapi.api.AuthManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    /**
     *
     */
    private final Context context;

    public HeaderInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // generar request
        Request original = chain.request();

        // Obtener token
        AuthManager auth = AuthManager.get(context);

        Request request = original.newBuilder()
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Authorization", "Bearer " + auth.getData().get("ACCESS_TOKEN"))
                .method(original.method(), original.body())
                .build();

        return chain.proceed(request);
    }
}
