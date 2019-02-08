package com.example.lkcenteno.conexionapi.models;

import com.google.gson.annotations.SerializedName;

public class Ibeacon {
    @SerializedName("rssi")
    private int rssi;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("major")
    private int major;

    @SerializedName("minor")
    private int minor;

    @SerializedName("measuredPower")
    private int measuredPower;

    @SerializedName("timestamp")
    private String timestamp;

    public Ibeacon() {
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getMeasuredPower() {
        return measuredPower;
    }

    public void setMeasuredPower(int measuredPower) {
        this.measuredPower = measuredPower;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
