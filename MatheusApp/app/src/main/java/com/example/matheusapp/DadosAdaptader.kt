package com.example.matheusapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DadosAdapter(private val listaDados: List<Usuario>) : RecyclerView.Adapter<DadosAdapter.DadoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DadoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dado, parent, false)
        return DadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DadoViewHolder, position: Int) {
        val dado = listaDados[position]
        holder.bind(dado)
    }

    override fun getItemCount(): Int {
        return listaDados.size
    }

    inner class DadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomeTextView: TextView = itemView.findViewById(R.id.text_nome)
        private val emailTextView: TextView = itemView.findViewById(R.id.text_email)

        fun bind(dado: Usuario) {
            nomeTextView.text = dado.nome
            emailTextView.text = dado.email
        }
    }

}




