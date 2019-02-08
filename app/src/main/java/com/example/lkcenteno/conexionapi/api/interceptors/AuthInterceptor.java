package com.example.lkcenteno.conexionapi.api.interceptors;

import android.content.Context;
import android.widget.Toast;

import com.example.lkcenteno.conexionapi.api.exceptions.AuthException;
import com.example.lkcenteno.conexionapi.models.ErrorModel;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class AuthInterceptor implements Interceptor {

    private Context context;

    public AuthInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // generar request
        Request original = chain.request();

        Response response = chain.proceed(original);

        if (response.code() == 401) {

            if (response.body() != null) {
                String bodyString = response.body().string();
                try {
                    JSONObject error = new JSONObject(bodyString);
                    ErrorModel data = new ErrorModel();
                    data.setError(error.getString("error"));
                    data.setMessage(error.getString("message"));
                    if (data.getError().equals("unauthenticated")) {
                        throw new AuthException(context);
                    }
                } catch (JSONException e) {
                    Toast.makeText(context, "Error al procesar codigo 401", Toast.LENGTH_LONG).show();
                }

                return response.newBuilder()
                        .body(ResponseBody.create(response.body().contentType(), bodyString))
                        .build();
            }
        }

        return response;
    }



}
