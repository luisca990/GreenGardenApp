package com.example.greengardenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greengardenapp.database.DataBase;
import com.example.greengardenapp.models.UserModel;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    Button btn_login;
    Button btn_register;

    EditText edt_email, edt_name, edt_password, edt_passwordConfirm;

    CheckBox chxTerms, chxNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_login = findViewById(R.id.btnGoLogin);
        btn_register = findViewById(R.id.btn_register);
        edt_email = findViewById(R.id.edtEmail);
        edt_name = findViewById(R.id.edtName);
        edt_password = findViewById(R.id.edtPassword);
        edt_passwordConfirm = findViewById(R.id.edtConfirmPassword);
        chxTerms = findViewById(R.id.chxTerms);
        chxNews = findViewById(R.id.chxNews);


        DataBase database = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                "GreenGarden"
        ).allowMainThreadQueries().build();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_email.getText().toString();
                String name = edt_name.getText().toString();
                String password = edt_password.getText().toString();
                String confirmPassword = edt_passwordConfirm.getText().toString();
                Boolean terms = chxTerms.isChecked();
                Boolean news = chxNews.isChecked();

                if(verifyInputs(email,name,password,confirmPassword,terms)){
                    if(verifyPassword(password,confirmPassword)){
                        UserModel user = new UserModel(email,name,password,terms,news);
                        try {
                            database.daoUser().insertUser(user);

                            showToast("Se registro el usuario " + user.getName());
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }catch (Exception e){
                            showToast("El usuario ya existe");
                            Log.e("ERROR AL CREAR USUARIO", e.toString());
                        }
                    }else{
                        showToast("Las contraseñas no coinciden");
                    }
                }else{
                    showToast("Complete todo el formulario");
                }



            }
        });
    }

    private Boolean verifyInputs(String email, String name, String password,String confirmPassword, Boolean terms){
        if(email.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||!terms){
            return false;
        }else{
            return true;
        }
    }

    private Boolean verifyPassword(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return true;
        }else{
            return false;
        }
    }

    private void showToast(String message){
        Toast toast = Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_SHORT);
        toast.show();
    }
}