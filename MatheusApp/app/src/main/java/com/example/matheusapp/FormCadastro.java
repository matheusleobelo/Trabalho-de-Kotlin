package com.example.matheusapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class FormCadastro extends AppCompatActivity {

    private TextView button_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        getSupportActionBar().hide();
        IniciarComponentes();


        button_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormCadastro.this,FormLogin.class);
                startActivity(intent);
            }
        });

    }
    private void IniciarComponentes(){
        button_cadastro = findViewById(R.id.button_cadastro);
    }
}