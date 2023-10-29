package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryAbonoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_abono);

        Button buttonCalcularAbono = findViewById(R.id.btn_calcular_abono);
        buttonCalcularAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(CategoryAbonoActivity.this, EstadisticasActivity.class);
                startActivity(login);
            }
        });

    }
}
