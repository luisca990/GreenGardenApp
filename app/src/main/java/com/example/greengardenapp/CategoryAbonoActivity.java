package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.greengardenapp.database.DataBase;
import com.example.greengardenapp.models.FertilizerModel;
import com.example.greengardenapp.models.WaterModel;

import java.util.List;

public class CategoryAbonoActivity extends AppCompatActivity {
    ImageButton btnReturn;
    EditText inputKilogramos, inputCosto;
    Spinner inputMonths;
    Button buttonCalcularAbono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_abono);

        inputKilogramos = findViewById(R.id.inputKilogramos);
        inputCosto = findViewById(R.id.inputCosto);
        inputMonths = findViewById(R.id.spinMonths);
        btnReturn = findViewById(R.id.LogoBack);
        buttonCalcularAbono = findViewById(R.id.btn_calcular_abono);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_list_item_1);
        inputMonths.setAdapter(adapter);

        DataBase database2 = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                "GreenGarden"
        ).allowMainThreadQueries().build();

        buttonCalcularAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                String inputPesoText = inputKilogramos.getText().toString();
                String inputCostoText = inputCosto.getText().toString();
                String inputMesText = inputMonths.getSelectedItem().toString();
                showToast("HOLA "+inputPesoText+" "+inputCostoText+" "+inputMesText);
                Log.d("SPINNER ES", inputMesText);
                if(validateInputs(inputPesoText,inputCostoText,inputMesText)){
                    try {
                        FertilizerModel fertilizerModel = new FertilizerModel(inputMesText,Integer.parseInt(inputPesoText),Integer.parseInt(inputCostoText));
                        database2.daoFertilizer().insertFertilizer(fertilizerModel);
                        showToast("Se ha registrado la información correctamente");
                        Intent login = new Intent(CategoryAbonoActivity.this, EstadisticasActivity.class);
                        startActivity(login);
                    }catch (Exception e){
                        showToast("Se ha producido un error:"+e.getMessage().toString());
                        Intent login = new Intent(CategoryAbonoActivity.this, PrincipalActivity.class);
                        startActivity(login);

                    }

                }else{
                    showToast("Por favor llene todo el formulario");
                }

            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(CategoryAbonoActivity.this, PrincipalActivity.class);
                startActivity(back);
            }
        });
        buttonCalcularAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(CategoryAbonoActivity.this, EstadisticasActivity.class);
                startActivity(login);
            }
        });

    }
    private boolean validateInputs(String peso, String costo, String mes){
        if(peso.isEmpty() || costo.isEmpty() || mes.isEmpty()){
            return false;
        }
        return true;
    }

    private void showToast(String message){
        Toast toast = Toast.makeText(CategoryAbonoActivity.this,message,Toast.LENGTH_LONG);
        toast.show();
    }
}
