package com.example.covid_21valles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PaisesAdapter(paises:ArrayList<País>,contexto:Context):RecyclerView.Adapter<PaisesAdapter.ViewHolder>() {
    var listaPaises:ArrayList<País>?=null
    var contexto:Context?=null

    init {
        this.listaPaises = paises
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesAdapter.ViewHolder {
        val vistaPaís:View = LayoutInflater.from(contexto).inflate(R.layout.paises_item,parent,false)
        val paisViewHolder = ViewHolder(vistaPaís)
        vistaPaís.tag = paisViewHolder
        return paisViewHolder
    }

    override fun getItemCount(): Int {
        return listaPaises!!.count()
    }

    override fun onBindViewHolder(holder: PaisesAdapter.ViewHolder, position: Int) {
        holder.nombrePais!!.text = listaPaises!![position].nombre
        holder.numeroConfirmados!!.text = "${ listaPaises!![position].confirmados }"
        holder.numeroMuertos!!.text = "${ listaPaises!![position].muertos }"
        holder.numeroRecuperados!!.text = "${ listaPaises!![position].recuperados }"
        Picasso.get().load("https://www.countryflags.io/${listaPaises!![position].codigoPais}/flat/64.png").into(holder.bandera)
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        var nombrePais:TextView?=null
        var numeroConfirmados:TextView?=null
        var numeroMuertos:TextView?=null
        var numeroRecuperados:TextView?=null
        var bandera:ImageView?=null

        init {
            nombrePais = vista.findViewById(R.id.tvnombrePais)
            numeroConfirmados = vista.findViewById(R.id.tvConfirmados)
            numeroMuertos = vista.findViewById(R.id.tvMuertos)
            numeroRecuperados = vista.findViewById(R.id.tvRecuperados)
            bandera = vista.findViewById(R.id.ivBandera)
        }
    }


}