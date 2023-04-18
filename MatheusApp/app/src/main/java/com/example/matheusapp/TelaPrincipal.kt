package com.example.matheusapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaPrincipal : AppCompatActivity() {
    var textNomeUsuario: TextView? = null
    var textNomeEmailUsuario: TextView? = null
    private var button_logout: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        textNomeUsuario = findViewById<View>(R.id.textNomeUsuario) as TextView
        textNomeEmailUsuario = findViewById<View>(R.id.textNomeEmailUsuario) as TextView
        val valor = intent.getStringExtra("chave")
        val valor1 = intent.getStringExtra("chave1")
        textNomeUsuario!!.text = valor1
        textNomeEmailUsuario!!.text = valor
        supportActionBar!!.hide()
        IniciarComponentes()
        button_logout!!.setOnClickListener {
            val intent = Intent(this@TelaPrincipal, FormLogin::class.java)
            startActivity(intent)
        }
    }

    private fun IniciarComponentes() {
        button_logout = findViewById(R.id.button_logout)
    }
}