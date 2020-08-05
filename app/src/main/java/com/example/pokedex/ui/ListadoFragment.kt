package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.data.PkmnViewModel
import com.example.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.fragment_listado.*


class ListadoFragment : Fragment(), OnItemClickListener{

    private var adapter: PokemonAdapter? = null
    private var pkmnViewModel = PkmnViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configAdapter()
        //configRecyclerView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false)
    }

    fun configAdapter(){
        adapter = PokemonAdapter(pkmnViewModel.pkmns, this)
    }

    private fun configRecyclerView() {
//        rvPokemon.layoutManager = LinearLayoutManager(parentFragment!!.context)
        rvPokemon.adapter = adapter
    }



    override fun onItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }

}