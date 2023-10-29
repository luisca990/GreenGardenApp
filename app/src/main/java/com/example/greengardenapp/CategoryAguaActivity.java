package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryAguaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_agua);

        Button buttonCalcularAgua = findViewById(R.id.btn_calcular_agua);
        buttonCalcularAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(CategoryAguaActivity.this, EstadisticasActivity.class);
                startActivity(login);
            }
        });

    }
}
