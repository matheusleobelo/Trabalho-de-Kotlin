package com.example.matheusapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DadosAdapter(private val listaDados: List<Usuario>) : RecyclerView.Adapter<DadosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dado, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dado = listaDados[position]
        holder.nomeTextView.text = dado.nome
    }

    override fun getItemCount(): Int {
        return listaDados.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nomeTextView : TextView = itemView.findViewById(R.id.text_nome)

        //private val nomeTextView: TextView = itemView.findViewById(R.id.text_nome)
        // val emailTextView: TextView = itemView.findViewById(R.id.text_email)

        //fun bind(dado: Usuario) {
         //   nomeTextView.text = dado.nome
          //  emailTextView.text = dado.email
        }
    }





