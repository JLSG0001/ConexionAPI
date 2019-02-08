package com.example.lkcenteno.conexionapi.api.service;

import com.example.lkcenteno.conexionapi.models.BeaconsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiBeacons {


    @GET("beacons")
    Call<BeaconsModel> getIndex();

}
