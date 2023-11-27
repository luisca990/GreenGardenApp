package com.example.greengardenapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greengardenapp.database.DataBase;
import com.example.greengardenapp.models.UserModel;


public class LoginActivity extends AppCompatActivity {

    Button btn_register;
    Button btn_login;

    EditText edt_email, edt_password;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_register = findViewById(R.id.btnGoRegister);
        btn_login = findViewById(R.id.btn_inicio);

        edt_email = findViewById(R.id.edtEmailLogin);
        edt_password = findViewById(R.id.edtPasswordLogin);

        dataBase = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                "GreenGarden"
        ).allowMainThreadQueries().build();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                if (verifyInputs(email,password)){
                    UserModel user = verifyUser(email,password);
                    if(user != null){
                        showToast("Bienvenido " + user.getName());
                        Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                        startActivity(intent);
                    }else{
                        showToast("Correo o contraseña incorrectos");
                    }

                }else{
                    showToast("Complete todo el formulario");
                }

            }
        });
    }

    private Boolean verifyInputs(String email, String password){
        if(email.isEmpty() || password.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private UserModel verifyUser(String email, String password){
        UserModel user = dataBase.daoUser().getUser(email,password);
        if(user != null){
            return user;
        }
        return null;
    }

    private void showToast(String message){
        Toast toast = Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG);
        toast.show();
    }
}

