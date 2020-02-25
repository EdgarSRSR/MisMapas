package com.solrom.edgar.mismapas;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// establishes the actions to show the maps

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Double latitud;
    private Double longitud;
    private String lugar;
    private Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        btnregresar = (Button) findViewById(R.id.btnRegresar);
        btnregresar.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            // latitude, if it can't find it shows a message that says "didn't find latitude"
            latitud = extras.getDouble("latitud");
            if(latitud == null){
                Toast.makeText(this, "No se encuentra la latitud.", Toast.LENGTH_SHORT).show();
                return;
            }
            // longitude, if it can't find it shows a message that says "didn't find longitude"
            longitud = extras.getDouble("longitud");
            if(longitud == null){
                Toast.makeText(this, "No se encuentra la longitud.", Toast.LENGTH_SHORT).show();
                return;
            }
            // place, if it can't find it shows a message that says "didn't find place"
            lugar = extras.getString("lugar");
            if(lugar == null){
                Toast.makeText(this, "No hay descripción de este lugar.", Toast.LENGTH_SHORT).show();
                return;
            }

        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng parque = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(parque).title(lugar).icon(BitmapDescriptorFactory.fromResource(R.drawable.icons8_terraria_48)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(parque));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitud, longitud),16.0f));
    }

    public void regresar(View v){

        switch (v.getId()){
            case R.id.btnRegresar:
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnregresar)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
