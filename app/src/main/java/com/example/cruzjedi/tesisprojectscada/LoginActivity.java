package com.example.cruzjedi.tesisprojectscada;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cruzjedi.tesisprojectscada.io.model.LoginResponse;
import com.example.cruzjedi.tesisprojectscada.io.model.ScadaApiAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Cruz on 30/11/2015.
 */
public class LoginActivity extends AppCompatActivity{
    private Button loginUser;
    private EditText user, password;
    private ScadaApiAdapter scadaApiAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Retrieve objects

        user = (EditText) findViewById(R.id.edtxt_user);
        password = (EditText) findViewById(R.id.edtxt_password);
        loginUser = (Button) findViewById(R.id.btn_login_user);



        //Eventos del Boton Login
        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(user.getText().toString())){
                    //Caja Usuario
                    Toast.makeText(getApplicationContext(),"Usuario vacio", Toast.LENGTH_SHORT).show();
                    Log.i("Usr: ", user.getText().toString());

                }else if(TextUtils.isEmpty(password.getText().toString())){
                    //password vacio
                    Toast.makeText(getApplicationContext(),"Password vacio", Toast.LENGTH_SHORT).show();
                    Log.i("Pass: ", password.getText().toString());
                }else {
                    //Usuario y Password ingresado
                    scadaApiAdapter =new ScadaApiAdapter();
                    scadaApiAdapter.getLogin(user.getText().toString(), password.getText().toString(),
                            new Callback<LoginResponse>() {

                                @Override
                                public void success(LoginResponse loginResponse, Response response) {
                                    //Contraseña y password Match
                                    if(TextUtils.equals(loginResponse.getRespuestaLogin(),"true" ) ){
                                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                    //Contraseña y password no son las adecuadas
                                        Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña\nIncorrecta ", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void failure(RetrofitError error) {
                                    Toast.makeText(getApplicationContext(),"Sin conexión",Toast.LENGTH_SHORT).show();

                                }
                            });

                }
            }
        });
    }
}
