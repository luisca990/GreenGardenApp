package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PuntoVerdesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntoverde);

        Button buttonPunto = findViewById(R.id.ejemploPuntoVerde);
        buttonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(PuntoVerdesActivity.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });

    }
}
