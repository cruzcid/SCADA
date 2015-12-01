package com.example.cruzjedi.tesisprojectscada;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Cruz on 30/11/2015.
 */
public class LoginActivity extends AppCompatActivity{

    private Button loginUser;
    private EditText user, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUser = (Button) findViewById(R.id.btn_login_user);
        user = (EditText) findViewById(R.id.edtxt_user);
        password = (EditText) findViewById(R.id.edtxt_password);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
