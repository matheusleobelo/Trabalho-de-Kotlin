package com.example.matheusapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FormCadastro : AppCompatActivity() {
    var edit_nome: EditText? = null
    var edit_email: EditText? = null
    var button_cadastro1: Button? = null
    private var button_cadastro: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar!!.hide()
        IniciarComponentes()
        edit_email = findViewById<View>(R.id.edit_email) as EditText
        edit_nome = findViewById<View>(R.id.edit_nome) as EditText
        button_cadastro1 = findViewById<View>(R.id.button_cadastro) as Button
        button_cadastro1!!.setOnClickListener {
            val intent = Intent(this@FormCadastro, TelaPrincipal::class.java)
            intent.putExtra("chave", edit_email!!.text.toString())
            intent.putExtra("chave1", edit_nome!!.text.toString())
            startActivity(intent)
        }
    }

    private fun IniciarComponentes() {
        button_cadastro = findViewById(R.id.button_cadastro)
    }
}