package com.example.pokedex.model

class Pokemon {

    companion object{
        var NORMAL = "Normal"
        var ACERO = "Acero"
        var FANTASMA = "Fantasma"
        var AGUA = "Agua"
        var FUEGO = "Fuego"
        var PLANTA = "Planta"
        var ROCA = "Roca"
        var TIERRA = "Tierra"
        var HADA = "Hada"
        var HIELO = "Hielo"
        var VENENO = "Veneno"
        var LUCHA = "Lucha"
        var SINIESTRO = "Siniestro"
        var DRAGON = "Dragon"
        var VOLADOR = "Volador"
        var ELECTRICO = "Electrico"
        var BICHO = "Bicho"
        var PSIQUICO = "Psiquico"
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