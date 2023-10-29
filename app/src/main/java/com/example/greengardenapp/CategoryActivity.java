package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button buttonCategoriaagua = findViewById(R.id.ejemploCategoriaagua);
        buttonCategoriaagua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryAguaActivity.class);
                startActivity(intent);
            }
        });

        Button buttonCategoriaabono = findViewById(R.id.ejemploCategoriaabono);
        buttonCategoriaabono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryAbonoActivity.class);
                startActivity(intent);
            }
        });

        Button buttonCategoriacompost = findViewById(R.id.ejemploCategoriacompost);
        buttonCategoriacompost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryCompostActivity.class);
                startActivity(intent);
            }
        });

    }

}
