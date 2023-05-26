package com.example.matheusapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FormCadastro : AppCompatActivity() {
    //variaveis
    var edit_nome: EditText? = null
    var edit_email: EditText? = null
    var edit_numero_vaga: EditText? = null
    var edit_localizacao_vaga: EditText? = null

    //botoes
    var button_cadastro1: Button? = null
    private var button_cadastro: TextView? = null

    //database && referencia
    private lateinit var database: FirebaseDatabase
    private lateinit var usuariosRef: DatabaseReference
    private lateinit var vagasRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar!!.hide()
        IniciarComponentes()
        edit_email = findViewById<View>(R.id.edit_email) as EditText
        edit_nome = findViewById<View>(R.id.edit_nome) as EditText
        button_cadastro1 = findViewById<View>(R.id.button_cadastro) as Button

        //firebase
        database = FirebaseDatabase.getInstance()
        usuariosRef = database.getReference("usuarios")


        button_cadastro1!!.setOnClickListener {

            //Usuario
            val nome = edit_nome!!.text.toString()
            val email = edit_email!!.text.toString()
            val novoUsuario = Usuario(nome, email, "")
            val novoUsuarioRef = usuariosRef.push()
            novoUsuarioRef.setValue(novoUsuario)

            //Vaga && fiz mas acabou que não vou usar
            val numeroVaga = edit_numero_vaga!!.text.toString()
            val localizacaoVaga = edit_localizacao_vaga!!.text.toString()
            val disponibilidadeVaga = true
            val novaVaga = Vaga(numeroVaga, localizacaoVaga, disponibilidadeVaga)
            val novaVagaRef = vagasRef.push()
            novaVagaRef.setValue(novaVaga)


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