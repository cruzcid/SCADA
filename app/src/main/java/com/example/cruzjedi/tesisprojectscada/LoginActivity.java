package com.example.cruzjedi.tesisprojectscada;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Cruz on 30/11/2015.
 */
public class LoginActivity extends AppCompatActivity{

    private Button logUser;
    private EditText user, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);/*
        logUser = (Button) findViewById(R.i.btn_log_user);
        user = (EditText) findViewById(R.id.edtxt_password);
        password = (EditText) findViewById(R.id.edtxt_password);*/

    }

}
