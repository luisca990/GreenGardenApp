package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TipsConsejosActivitys extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        Button buttonTips = findViewById(R.id.ejemploEstadistica);
        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(TipsConsejosActivitys.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });

    }
}
