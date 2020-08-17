package com.example.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.data.PkmnViewModel
import com.example.pokedex.model.Pokemon
import com.example.pokedex.ui.ListadoFragment
import com.example.pokedex.ui.OnItemClickListener
import com.example.pokedex.ui.PokemonAdapter
import kotlinx.android.synthetic.main.fragment_listado.*

//Proyecto de prueba para sincronizacion con git
//HeatWave
//Nieto
//NewEdit
class MainActivity : AppCompatActivity(), OnItemClickListener {
//TODO Reconocer si los cambios deben hacerse aqui o en listado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }


}