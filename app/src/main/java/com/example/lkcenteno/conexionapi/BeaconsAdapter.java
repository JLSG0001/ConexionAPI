package com.example.lkcenteno.conexionapi;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lkcenteno.conexionapi.models.Beacons;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class BeaconsAdapter extends RecyclerView.Adapter<BeaconsAdapter.ViewHolder> {
    private List<Beacons> beaconsList;

    public BeaconsAdapter(List<Beacons> beaconsList) {
        this.beaconsList = beaconsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_beacons, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        float temperatura = 0;
        int rssi = 0;
        
        String NS = beaconsList.get(i).getBdaddr();
        String ID = beaconsList.get(i).getModel();

        try {
            temperatura = beaconsList.get(i).getSensor().getTemperature();
            rssi = beaconsList.get(i).getSensor().getRssi();
        } catch (Exception e) {
            Log.d(TAG, "onBindViewHolder: datos perdidos");
        }


        viewHolder.textViewNS.setText(NS);
        viewHolder.textViewID.setText(" "+ID);
        viewHolder.textViewTemperatura.setText(Float.toString(temperatura)+" °C");
        viewHolder.textViewRSSI.setText(" "+String.valueOf(rssi));

    }

    @Override
    public int getItemCount() {
        return beaconsList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNS;
        TextView textViewID;
        TextView textViewTemperatura;
        TextView textViewRSSI;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNS = itemView.findViewById(R.id.textViewNS);
            textViewID = itemView.findViewById(R.id.textViewID);
            textViewTemperatura = itemView.findViewById(R.id.textViewTemperatura);
            textViewRSSI = itemView.findViewById(R.id.textViewRSSI);


        }
    }


    public void add(List<Beacons> list) {
        int lastIndex = list.size();
        this.beaconsList.addAll(list);
        notifyItemRangeChanged(lastIndex, list.size());
    }


}
