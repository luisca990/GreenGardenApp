package com.example.greengardenapp;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        Button buttonBienvenida = findViewById(R.id.BLogin);
        buttonBienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent bienvenida = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(bienvenida);
            }
        });
    }
}

