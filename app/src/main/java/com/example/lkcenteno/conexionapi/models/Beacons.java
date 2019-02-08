package com.example.lkcenteno.conexionapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Beacons {

    @SerializedName("bdaddr")
    private String bdaddr;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("rssi")
    private int rssi;

    @SerializedName("connectable")
    private boolean connectable;

    @SerializedName("model")
    private String model;

    @SerializedName("serial")
    private String serial;

        @SerializedName("ibeacon")
        @Expose
        private ArrayList<Ibeacon> ibeacon;

    @SerializedName("sensor")
    @Expose
    private Sensor sensor;

    public Beacons() {
    }

    public String getBdaddr() {
        return bdaddr;
    }

    public void setBdaddr(String bdaddr) {
        this.bdaddr = bdaddr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public boolean isConnectable() {
        return connectable;
    }

    public void setConnectable(boolean connectable) {
        this.connectable = connectable;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public ArrayList<Ibeacon> getIbeacon() {
        return ibeacon;
    }

    public void setIbeacon(ArrayList<Ibeacon> ibeacon) {
        this.ibeacon = ibeacon;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}