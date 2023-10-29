package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageButton buttonCategoriaAgua = findViewById(R.id.imageButtonAgua);
        buttonCategoriaAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryAguaActivity.class);
                startActivity(intent);
            }
        });

        ImageButton buttonCategoriaAbono = findViewById(R.id.imageButtonAbono);
        buttonCategoriaAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryAbonoActivity.class);
                startActivity(intent);
            }
        });

        ImageButton buttonCategoriaCompost = findViewById(R.id.imageButtonCompost);
        buttonCategoriaCompost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryCompostActivity.class);
                startActivity(intent);
            }
        });

    }

}
