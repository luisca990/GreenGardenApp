package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.greengardenapp.database.DataBase;
import com.example.greengardenapp.models.WaterModel;

public class CategoryAguaActivity extends AppCompatActivity {

    Button btnReturn;
    EditText inputLitros, inputCosto, inputMes;
    Spinner inputMonths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_agua);

        inputLitros = findViewById(R.id.inputLitros);
        inputCosto = findViewById(R.id.inputCosto);
        inputMonths = findViewById(R.id.spinMonths);
        Button buttonCalcularAgua = findViewById(R.id.btn_calcular_agua);
        btnReturn = findViewById(R.id.btn_return);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_list_item_1);
        inputMonths.setAdapter(adapter);

        DataBase database = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                "GreenGarden"
        ).allowMainThreadQueries().build();
        buttonCalcularAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                String inputLitrosText = inputLitros.getText().toString();
                String inputCostoText = inputCosto.getText().toString();
                String inputMesText = inputMonths.getSelectedItem().toString();
                Log.d("SPINNER ES", inputMesText);
                if(validateInputs(inputLitrosText,inputCostoText,inputMesText)){
                    try {
                        WaterModel waterModel = new WaterModel(inputMesText,Integer.parseInt(inputLitrosText),Integer.parseInt(inputCostoText));
                        database.daoWater().insertWater(waterModel);
                    }catch (Exception e){

                    }
                    showToast("Se ha registrado la información correctamente");
                    Intent login = new Intent(CategoryAguaActivity.this, EstadisticasActivity.class);
                    startActivity(login);
                }else{
                    showToast("Por favor llene todo el formulario");
                }

            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(CategoryAguaActivity.this, EstadisticasActivity.class);
                startActivity(back);
            }
        });
    }

    private boolean validateInputs(String litros, String costo, String mes){
        if(litros.isEmpty() || costo.isEmpty() || mes.isEmpty()){
            return false;
        }
        return true;
    }

    private void showToast(String message){
        Toast toast = Toast.makeText(CategoryAguaActivity.this,message,Toast.LENGTH_LONG);
        toast.show();
    }
}
