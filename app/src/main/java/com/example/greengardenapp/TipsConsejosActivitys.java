package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TipsConsejosActivitys extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        CardView buttonTipsriego = findViewById(R.id.cardViewriego);
        buttonTipsriego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(TipsConsejosActivitys.this, TipsConsejosActivitysRiego.class);
                startActivity(intent);
            }
        });

        CardView buttonTipsenergia = findViewById(R.id.cardViewenergia);
        buttonTipsenergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(TipsConsejosActivitys.this, TipsConsejosActivitysEnergia.class);
                startActivity(intent);
            }
        });

        CardView buttonTipsabono = findViewById(R.id.cardViewabono);
        buttonTipsabono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(TipsConsejosActivitys.this, TipsConsejosActivitysAbono.class);
                startActivity(intent);
            }
        });

        CardView buttonTipsreciclaje = findViewById(R.id.cardViewreciclaje);
        buttonTipsreciclaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(TipsConsejosActivitys.this, TipsConsejosActivitysReciclaje.class);
                startActivity(intent);
            }
        });


    }
}
