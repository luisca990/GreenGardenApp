package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EstadisticasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        Button buttonEstadistica = findViewById(R.id.ejemploEstadistica);
        buttonEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(EstadisticasActivity.this, PrincipalActivity.class);
                startActivity(login);
            }
        });

    }
}
