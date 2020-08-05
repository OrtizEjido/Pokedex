package com.example.pokedex.ui

import com.example.pokedex.model.Pokemon


interface OnItemClickListener {

    fun onItemClick(pokemon: Pokemon?)
    fun onLongItemClick(pokemon: Pokemon?)

}