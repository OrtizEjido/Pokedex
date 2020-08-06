package com.example.pokedex.model

class Pokemon {

    companion object{
        const val NORMAL = "Normal"
        const val ACERO = "Acero"
        const val FANTASMA = "Fantasma"
        const val AGUA = "Agua"
        const val FUEGO = "Fuego"
        const val PLANTA = "Planta"
        const val ROCA = "Roca"
        const val TIERRA = "Tierra"
        const val HADA = "Hada"
        const val HIELO = "Hielo"
        const val VENENO = "Veneno"
        const val LUCHA = "Lucha"
        const val SINIESTRO = "Siniestro"
        const val DRAGON = "Dragon"
        const val VOLADOR = "Volador"
        const val ELECTRICO = "Electrico"
        const val BICHO = "Bicho"
        const val PSIQUICO = "Psiquico"
    }

    constructor(id: Int?, nombre: String?, imageUrl: String?, tipo: String?, tipo2: String? = null) {
        this.id = id
        this.nombre = nombre
        this.imageUrl = imageUrl
        this.tipo = tipo
        this.tipo2 = tipo2
    }

    var id: Int? = null
    var nombre: String? = null
    var imageUrl: String? = null
    var tipo: String? = null
    var tipo2: String? = null

    fun idString(): String {
        return if (id!!<10) "#00$id"
        else if (id!!<100)"#0$id"
        else "#$id"
    }

}