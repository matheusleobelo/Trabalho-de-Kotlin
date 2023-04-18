package com.example.matheusapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FormLogin : AppCompatActivity() {
    var edit_email: EditText? = null
    var bt_entrar1: Button? = null
    private var text_tela_cadastro: TextView? = null
    private var bt_entrar: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        edit_email = findViewById<View>(R.id.edit_email) as EditText
        bt_entrar1 = findViewById<View>(R.id.bt_entrar) as Button
        supportActionBar!!.hide()
        IniciarComponentes()
        IniciarComponentePrincipal()
        text_tela_cadastro!!.setOnClickListener {
            val intent = Intent(this@FormLogin, FormCadastro::class.java)
            startActivity(intent)
        }
        bt_entrar!!.setOnClickListener {
            val intent = Intent(this@FormLogin, TelaPrincipal::class.java)
            intent.putExtra("chave", edit_email!!.text.toString())
            startActivity(intent)
            finish()
        }
    }

    private fun IniciarComponentes() {
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro)
    }

    private fun IniciarComponentePrincipal() {
        bt_entrar = findViewById(R.id.bt_entrar)
    }
}