package com.example.lkcenteno.conexionapi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lkcenteno.conexionapi.api.ApiManager;
import com.example.lkcenteno.conexionapi.models.Beacons;
import com.example.lkcenteno.conexionapi.models.BeaconsModel;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 4000; // 4 segundos
    RecyclerView recyclerViewBeacons;
    BeaconsAdapter beaconsAdapter;
    List<Beacons> beaconsList;
    private boolean activo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        recyclerViewBeacons = findViewById(R.id.recycler_view_beacons);
        GridLayoutManager manager;
        manager = new GridLayoutManager(MainActivity.this, 1);

        recyclerViewBeacons.setLayoutManager(manager);


        mostrarDatos();


    }

    private void mostrarDatos() {
        ApiManager apiManager = new ApiManager(getApplicationContext());
        apiManager.getApiBeacons().getIndex().enqueue(new Callback<BeaconsModel>() {
            @Override
            public void onResponse(Call<BeaconsModel> call, Response<BeaconsModel> response) {
                if (response.isSuccessful()) {

                    beaconsList = response.body().getBeacons();
                    beaconsAdapter = new BeaconsAdapter(beaconsList);
                    recyclerViewBeacons.setAdapter(beaconsAdapter);
                    if (activo) {
                        actualizar();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Falla de conexion:", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<BeaconsModel> call, Throwable t) {

            }
        });
    }


    private void actualizar() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    mostrarDatos();
                } catch (Exception e) {
                    Log.e("Main:", "problemas en peticion");
                }
            }
        }, DURACION_SPLASH);
    }

    @Override
    protected void onPause() {
        super.onPause();
        activo = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        activo=true;
        mostrarDatos();
    }
}
