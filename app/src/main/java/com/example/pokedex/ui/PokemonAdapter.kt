package com.example.pokedex.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.utils
import kotlinx.android.synthetic.main.item_pokemon_list.view.*


class PokemonAdapter(
    var pkmns: MutableList<Pokemon> = mutableListOf(),
    var listener: OnItemClickListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutID = 0
        if (utils.view == utils.LIST){
            layoutID = R.layout.item_pokemon_list
        } else {
            layoutID = R.layout.item_pokemon_grid
        }
        var view: View = LayoutInflater.from(parent.context).inflate(layoutID, parent, false)
        this.context = parent.context
        return PokemonViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PokemonViewHolder -> {
                val item= pkmns[position]
                holder.setListener(item, listener)
                holder.bind(item)

                var options = RequestOptions()
                options.diskCacheStrategy(DiskCacheStrategy.ALL)
                options.centerCrop()
                options.placeholder(R.drawable.ic_search)

                Glide.with(context!!)
                    .load(item.imageUrl)
                    .apply(options)
                    .into(holder.imgPhoto)
            }
        }
    }

    override fun getItemCount(): Int {
        //Regresa la cantidad de items en el recycler
        return pkmns.size
    }

    fun add(pokemon: Pokemon) {
        if (!pkmns.contains(pokemon)) {
            pkmns.add(pokemon)
            notifyDataSetChanged()
        }
    }

    fun submitList(pkmns: MutableList<Pokemon>){
        //actualizamos la lista
        this.pkmns = pkmns
    }

    class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgPhoto: ImageView = itemView.imgPhoto
        private var tvNombre: TextView = itemView.tvNombre
        private var tvNumero: TextView = itemView.tvNumero
        private var ivTipo: ImageView? = itemView.ivTipo
        private var ivTipo2: ImageView? = itemView.ivTipo2

//        private var containerMain: RelativeLayout = itemView.containerMain



        @SuppressLint("CheckResult")
        fun bind (pokemon: Pokemon){
            if (pokemon.imageUrl != null) {
//                var options = RequestOptions()
//                options.diskCacheStrategy(DiskCacheStrategy.ALL)
//                options.centerCrop()
//                options.placeholder(R.drawable.ic_search)
//
//                Glide.with(this.containerMain.context)
//                    .load(pokemon.imageUrl)
//                    .apply(options)
//                    .into(imgPhoto)

                tvNombre.text = pokemon.nombre
                tvNumero.text = pokemon.idString()

                if (utils.view == utils.LIST)   bindTipos(pokemon)





            }
        }

        fun bindTipos(pokemon: Pokemon){
            when(pokemon.tipo){
                Pokemon.ACERO -> ivTipo!!.setImageResource(R.drawable.tipo_acero)
                Pokemon.AGUA -> ivTipo!!.setImageResource(R.drawable.tipo_agua)
                Pokemon.BICHO -> ivTipo!!.setImageResource(R.drawable.tipo_bicho)
                Pokemon.DRAGON -> ivTipo!!.setImageResource(R.drawable.tipo_dragon)
                Pokemon.HADA -> ivTipo!!.setImageResource(R.drawable.tipo_hada)
                Pokemon.HIELO -> ivTipo!!.setImageResource(R.drawable.tipo_hielo)
                Pokemon.FUEGO -> ivTipo!!.setImageResource(R.drawable.tipo_fuego)
                Pokemon.NORMAL -> ivTipo!!.setImageResource(R.drawable.tipo_normal)
                Pokemon.LUCHA -> ivTipo!!.setImageResource(R.drawable.tipo_lucha)
                Pokemon.ROCA -> ivTipo!!.setImageResource(R.drawable.tipo_roca)
                Pokemon.TIERRA -> ivTipo!!.setImageResource(R.drawable.tipo_tierra)
                Pokemon.VENENO -> ivTipo!!.setImageResource(R.drawable.tipo_veneno)
                Pokemon.PSIQUICO -> ivTipo!!.setImageResource(R.drawable.tipo_psiquico)
                Pokemon.SINIESTRO -> ivTipo!!.setImageResource(R.drawable.tipo_siniestro)
                Pokemon.FANTASMA -> ivTipo!!.setImageResource(R.drawable.tipo_fantasma)
                Pokemon.ELECTRICO -> ivTipo!!.setImageResource(R.drawable.tipo_electrico)
                Pokemon.PLANTA -> ivTipo!!.setImageResource(R.drawable.tipo_planta)
                Pokemon.VOLADOR -> ivTipo!!.setImageResource(R.drawable.tipo_volador)
            }

            when(pokemon.tipo2){
                Pokemon.ACERO -> ivTipo2!!.setImageResource(R.drawable.tipo_acero)
                Pokemon.AGUA -> ivTipo2!!.setImageResource(R.drawable.tipo_agua)
                Pokemon.BICHO -> ivTipo2!!.setImageResource(R.drawable.tipo_bicho)
                Pokemon.DRAGON -> ivTipo2!!.setImageResource(R.drawable.tipo_dragon)
                Pokemon.HADA -> ivTipo2!!.setImageResource(R.drawable.tipo_hada)
                Pokemon.HIELO -> ivTipo2!!.setImageResource(R.drawable.tipo_hielo)
                Pokemon.FUEGO -> ivTipo2!!.setImageResource(R.drawable.tipo_fuego)
                Pokemon.NORMAL -> ivTipo2!!.setImageResource(R.drawable.tipo_normal)
                Pokemon.LUCHA -> ivTipo2!!.setImageResource(R.drawable.tipo_lucha)
                Pokemon.ROCA -> ivTipo2!!.setImageResource(R.drawable.tipo_roca)
                Pokemon.TIERRA -> ivTipo2!!.setImageResource(R.drawable.tipo_tierra)
                Pokemon.VENENO -> ivTipo2!!.setImageResource(R.drawable.tipo_veneno)
                Pokemon.PSIQUICO -> ivTipo2!!.setImageResource(R.drawable.tipo_psiquico)
                Pokemon.SINIESTRO -> ivTipo2!!.setImageResource(R.drawable.tipo_siniestro)
                Pokemon.FANTASMA -> ivTipo2!!.setImageResource(R.drawable.tipo_fantasma)
                Pokemon.ELECTRICO -> ivTipo2!!.setImageResource(R.drawable.tipo_electrico)
                Pokemon.PLANTA -> ivTipo2!!.setImageResource(R.drawable.tipo_planta)
                Pokemon.VOLADOR -> ivTipo2!!.setImageResource(R.drawable.tipo_volador)
                else -> ivTipo2!!.visibility = View.INVISIBLE
            }
        }

        fun setListener(pokemon: Pokemon?, listener: OnItemClickListener) {
//            containerMain.setOnClickListener { listener.onItemClick(pokemon) }
        }
    }
}