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
class MainActivity : AppCompatActivity(), OnItemClickListener {
//TODO Reconocer si los cambios deben hacerse aqui o en listado
    private var adapter: PokemonAdapter? = null
    private var pkmnViewModel = PkmnViewModel()
    var fragmentManager: FragmentManager = this.supportFragmentManager
    var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configAdapter()
        configRecyclerView()
        fragmentManager.beginTransaction()
        var listadoFragment = ListadoFragment()
        fragmentTransaction.commit()
        fragmentTransaction.add(listadoFragment, "alo")

    }

    fun configAdapter(){
        adapter = PokemonAdapter(pkmnViewModel.pkmns, this)
    }

    private fun configRecyclerView() {
        rvPokemon.layoutManager = LinearLayoutManager(this)
        rvPokemon.adapter = adapter
    }


    override fun onItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }


}