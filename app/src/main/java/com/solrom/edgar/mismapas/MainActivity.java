package com.solrom.edgar.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
    
    Creates maps with locations
    
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void irMapa(View v){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }*/

    // show maps
    public void mostrarMapa(View v){
        int ImageView = v.getId();

        switch (ImageView){
            case R.id.naucalli:
                // creates maps by introducing coordinates and a given name
                crearIntentMapa(MapsActivity.class, 19.49161800380091, -99.24013511684575, "Parque Naucalli");
                        break;
            case R.id.alamedaNorte:
                crearIntentMapa(MapsActivity.class, 19.500204536424565, -99.17833702114262, "Parque Alameda Norte");
                break;
            case R.id.bicentenario:
                crearIntentMapa(MapsActivity.class, 19.470124391556602, -99.19113652256169, "Parque Bicentenario");
                break;
            case R.id.plansexenal:
                crearIntentMapa(MapsActivity.class, 19.454495481070534, -99.17284385708012, "Deportivo Plan Sexenal");
                break;
        }
    }

    public void crearIntentMapa(Class<MapsActivity> mapsActivityClass, Double latitud, Double longitud, String lugar){
        Intent intentMapa = new Intent(this, mapsActivityClass);
        intentMapa.putExtra("latitud", latitud);
        intentMapa.putExtra("longitud", longitud);
        intentMapa.putExtra("lugar", lugar);
        startActivity(intentMapa);
    }



}
