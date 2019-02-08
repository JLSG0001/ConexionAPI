package com.example.lkcenteno.conexionapi.models;

import com.google.gson.annotations.SerializedName;

public class Sensor {

    @SerializedName("temperature")
    private float temperature;

    @SerializedName("humidity")
    private float humidity;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("rssi")
    private int rssi;

    @SerializedName("timestamp")
    private String timestamp;

    public Sensor() {
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
