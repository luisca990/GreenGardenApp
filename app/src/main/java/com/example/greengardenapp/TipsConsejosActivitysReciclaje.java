package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class TipsConsejosActivitysReciclaje extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_reciclaje);

        TextView buttonTipsriego = findViewById(R.id.footerText);
        buttonTipsriego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent intent = new Intent(TipsConsejosActivitysReciclaje.this, TipsConsejosActivitys.class);
                startActivity(intent);
            }
        });
    }
}
