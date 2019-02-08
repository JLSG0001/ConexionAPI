package com.example.lkcenteno.conexionapi.api.exceptions;

import android.content.Context;
import android.content.Intent;

import com.example.lkcenteno.conexionapi.UnavailableInternet;


import java.io.IOException;

public class UnavailableInternetException extends IOException {

    private Context context;

    public UnavailableInternetException(Context context) {
        this.context = context;
        activity();
    }

    private void activity() {
        context.startActivity(new Intent(context, UnavailableInternet.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    public String getMessage() {
        return "Sin conexión a internet";
    }

}
