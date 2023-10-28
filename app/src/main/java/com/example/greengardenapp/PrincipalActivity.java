package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageButton buttonConsejos = findViewById(R.id.tipsConsejos);
        buttonConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, TipsConsejosActivitys.class);
                startActivity(intent);
            }
        });

        ImageButton buttonPuntosVerdes = findViewById(R.id.puntosVerdes);
        buttonPuntosVerdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, PuntoVerdesActivity.class);
                startActivity(intent);
            }
        });

        ImageButton buttonCategorias = findViewById(R.id.categorias);
        buttonCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });



        ImageButton buttonEstadisticas = findViewById(R.id.estadisticas);
        buttonEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, EstadisticasActivity.class);
                startActivity(intent);
            }
        });

    }
}
