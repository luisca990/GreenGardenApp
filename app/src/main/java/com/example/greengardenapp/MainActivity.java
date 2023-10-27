package com.example.greengardenapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBienvenida = findViewById(R.id.BLogin);

        textView = findViewById(R.id.BtextoEnlace);

        SpannableString mitextoU = new SpannableString("Registrarme");
        mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
        textView.setText(mitextoU);


        buttonBienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent bienvenida = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(bienvenida);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar RegisterActivity
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
    }
}

