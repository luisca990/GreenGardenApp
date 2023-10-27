package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button buttonEstadistica = findViewById(R.id.tipsConsejos);
        buttonEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(PrincipalActivity.this, TipsConsejosActivitys.class);
                startActivity(login);
            }
        });

        Button buttonPuntosVerdes = findViewById(R.id.puntosVerdes);
        buttonPuntosVerdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent puntosVerdes = new Intent(PrincipalActivity.this, PuntoVerdesActivity.class);
                startActivity(puntosVerdes);
            }
        });

    }
}
