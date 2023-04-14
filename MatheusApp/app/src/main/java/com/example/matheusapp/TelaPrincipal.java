package com.example.matheusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    private TextView button_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        getSupportActionBar().hide();
        IniciarComponentes();

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TelaPrincipal.this, FormLogin.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        button_logout = findViewById(R.id.button_logout);
    }
}