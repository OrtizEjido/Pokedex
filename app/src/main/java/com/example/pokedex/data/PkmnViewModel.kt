package com.example.pokedex.data

import androidx.lifecycle.ViewModel
import com.example.pokedex.model.Pokemon

class PkmnViewModel: ViewModel() {

    var pkmns: MutableList<Pokemon> = mutableListOf(
        Pokemon(1, "Charmander",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
        Pokemon.FUEGO)
    )

}