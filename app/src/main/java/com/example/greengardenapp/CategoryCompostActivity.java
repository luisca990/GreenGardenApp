package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryCompostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_compost);

        Button buttonCalcularCompost = findViewById(R.id.btn_calcular_compost);
        buttonCalcularCompost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(CategoryCompostActivity.this, EstadisticasActivity.class);
                startActivity(login);
            }
        });

    }
}
