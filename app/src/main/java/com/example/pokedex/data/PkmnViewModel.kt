package com.example.pokedex.data

import androidx.lifecycle.ViewModel
import com.example.pokedex.model.Pokemon

class PkmnViewModel: ViewModel() {

    var pkmns: MutableList<Pokemon> = mutableListOf(
        Pokemon(1, "Bulbasaur",
            imageByID("001"),
            Pokemon.PLANTA, Pokemon.VENENO),
        Pokemon(2, "Ivysaur",
            imageByID("002"),
            Pokemon.PLANTA, Pokemon.VENENO),
        Pokemon(3, "Venasaur",
            imageByID("003"),
            Pokemon.PLANTA, Pokemon.VENENO),
        Pokemon(4, "Charmander",
            imageByID("004"),
            Pokemon.FUEGO),
        Pokemon(5, "Charmaleon",
            imageByID("005"),
            Pokemon.FUEGO),
        Pokemon(6, "Charizard",
            imageByID("006"),
            Pokemon.FUEGO, Pokemon.VOLADOR),
        Pokemon(7, "Squirtle",
            imageByID("007"),
            Pokemon.AGUA),
        Pokemon(8, "Wartotle",
            imageByID("008"),
            Pokemon.AGUA),
        Pokemon(9, "Blastoise",
            imageByID("009"),
            Pokemon.AGUA)
    )

    fun imageByID(id: String): String = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$id.png"

}