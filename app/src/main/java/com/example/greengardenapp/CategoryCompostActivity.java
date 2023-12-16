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
import com.example.greengardenapp.models.CompostModel;
import com.example.greengardenapp.models.FertilizerModel;

public class CategoryCompostActivity extends AppCompatActivity {
    ImageButton btnReturn;
    EditText inputAmong, inputPrice;
    Spinner inputMonths;
    Button buttonCalcularCompost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_compost);

        buttonCalcularCompost = findViewById(R.id.btn_calcular_compost);
        btnReturn=findViewById(R.id.LogoBack);
        inputAmong=findViewById(R.id.txtInAmong);
        inputPrice=findViewById(R.id.txtInPrice);
        inputMonths=findViewById(R.id.spinMonths);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_list_item_1);
        inputMonths.setAdapter(adapter);

        DataBase database2 = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                "GreenGarden"
        ).allowMainThreadQueries().build();

        buttonCalcularCompost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                String inputPesoText = inputAmong.getText().toString();
                String inputCostoText = inputPrice.getText().toString();
                String inputMesText = inputMonths.getSelectedItem().toString();
                Log.d("HOLA ",inputPesoText+" "+inputCostoText+" "+inputMesText);
                Log.d("SPINNER ES", inputMesText);
                if(validateInputs(inputPesoText,inputCostoText,inputMesText)){
                    try {
                        CompostModel compostModel = new CompostModel(inputMesText,Integer.parseInt(inputPesoText),Integer.parseInt(inputCostoText));
                        database2.daoCompost().insertCompost(compostModel);
                        showToast("Se ha registrado la información correctamente");
                        Intent login = new Intent(CategoryCompostActivity.this, EstadisticasActivity.class);
                        startActivity(login);
                    }catch (Exception e){
                        showToast("Se ha producido un error:"+e.getMessage().toString());
                        Intent login = new Intent(CategoryCompostActivity.this, PrincipalActivity.class);
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
                // Iniciar LoginActivity
                Intent login = new Intent(CategoryCompostActivity.this, PrincipalActivity.class);
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
        Toast toast = Toast.makeText(CategoryCompostActivity.this,message,Toast.LENGTH_LONG);
        toast.show();
    }
}
