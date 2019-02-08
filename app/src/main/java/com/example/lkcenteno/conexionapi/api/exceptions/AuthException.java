package com.example.lkcenteno.conexionapi.api.exceptions;

import android.content.Context;

import com.example.lkcenteno.conexionapi.api.AuthManager;

import java.io.IOException;

public class AuthException extends IOException {

    private static final String mensajeRA = "Se requiere autenticación";

    public AuthException(Context context) {
        Context context1 = context;
      //  forceLogout();
    }
/*
    private void forceLogout() {
        AuthManager auth = AuthManager.get(context);
        auth.logout(false);
    }
    */

    @Override
    public String getMessage() {
        return mensajeRA ;
    }

}