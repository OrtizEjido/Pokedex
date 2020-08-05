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
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(
    var pkmns: MutableList<Pokemon> = mutableListOf(),
    var listener: OnItemClickListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
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
                if (item.imageUrl != null){
                    var options = RequestOptions()
                    options.diskCacheStrategy(DiskCacheStrategy.ALL)
                    options.centerCrop()
                    options.placeholder(R.drawable.ic_search)


                    context?.let {
                        Glide.with(it)
                            .load(item.imageUrl)
                            .apply(options)
                            .into(holder.imgPhoto)
                    }

                }else{
                    holder.imgPhoto.setImageDrawable(context?.let { ContextCompat.getDrawable(it
                        ,R.drawable.ic_search) })
                }
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
        var tvNombre: TextView = itemView.tvNombre
        var tvNumero: TextView = itemView.tvNumero
        var containerMain: RelativeLayout = itemView.containerMain



        fun bind (pokemon: Pokemon){
            tvNombre.text =pokemon.nombre
            tvNumero.text = pokemon.id.toString()
        }

        fun setListener(pokemon: Pokemon?, listener: OnItemClickListener) {
            containerMain.setOnClickListener { listener.onItemClick(pokemon) }
        }
    }
}