package com.example.lkcenteno.conexionapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BeaconsModel {

    @SerializedName("result")
    private String result;

    @SerializedName("beacons")
    @Expose
    private ArrayList<Beacons> beacons;

    public BeaconsModel(String result, ArrayList<Beacons> beacons) {
        this.result = result;
        this.beacons = beacons;
    }

    public BeaconsModel() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Beacons> getBeacons() {
        return beacons;
    }

    public void setBeacons(ArrayList<Beacons> beacons) {
        this.beacons = beacons;
    }


}
