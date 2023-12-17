package com.example.greengardenapp;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class PuntoVerdesActivity extends AppCompatActivity {
    ImageButton btnBack;
    MapView mapView;
    EditText searchEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntoverde);
        btnBack=findViewById(R.id.LogoBack);

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        mapView = findViewById(R.id.mapView);
        searchEditText = findViewById(R.id.searchEditText);

        // Configuración del mapa
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        IMapController mapController = mapView.getController();
        mapController.setZoom(10.0);


        // Manejar el evento de búsqueda
        searchEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (3 == EditorInfo.IME_ACTION_SEARCH ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                // Ocultar el teclado después de presionar "Buscar" o "Enter"
                hideSoftKeyboard();

                // Realizar la geocodificación y centrar el mapa
                geocodeAndCenterMap(searchEditText.getText().toString());
                return true;
            }
            return false;
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(PuntoVerdesActivity.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });
    }

    private void geocodeAndCenterMap(String locationName) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocationName(locationName, 1);
            if (!addresses.isEmpty()) {
                Address address = addresses.get(0);
                double latitude = address.getLatitude();
                double longitude = address.getLongitude();

                // Crear un GeoPoint con las coordenadas
                GeoPoint geoPoint = new GeoPoint(latitude, longitude);

                // Centrar el mapa en las coordenadas encontradas
                mapView.getController().animateTo(geoPoint);

                // Añadir un marcador en la ubicación encontrada
                Marker startMarker = new Marker(mapView);
                startMarker.setPosition(geoPoint);
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                mapView.getOverlays().add(startMarker);
            }
        } catch (IOException e) {
            showToast(e.getMessage());
        }
    }
    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
    }
    private void showToast(String message){
        Toast toast = Toast.makeText(PuntoVerdesActivity.this,message,Toast.LENGTH_LONG);
        toast.show();
    }



}
