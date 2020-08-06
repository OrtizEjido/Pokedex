package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.data.PkmnViewModel
import com.example.pokedex.model.Pokemon
import com.example.pokedex.utils
import kotlinx.android.synthetic.main.fragment_listado.*


class ListadoFragment : Fragment(), OnItemClickListener{

    private var adapter: PokemonAdapter? = null
    private var pkmnViewModel = PkmnViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_listado, container, false)
        return view
    }
    //reescribimos por que necesitamos que se creen las vistas
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configAdapter()
        configRecyclerView()
        fab.setOnClickListener {
            if (utils.view == utils.LIST){
                fab.setImageResource(R.drawable.ic_list)
                utils.view = utils.GRID
            }else{
                fab.setImageResource(R.drawable.ic_grid)
                utils.view = utils.LIST
            }
            configRecyclerView()
        }
    }

    private fun configAdapter(){
        adapter = PokemonAdapter(pkmnViewModel.pkmns, this)
    }

    private fun configRecyclerView() {
        if (utils.view == utils.LIST) {
            rvPokemon.layoutManager = LinearLayoutManager(activity)
        } else {
            rvPokemon.layoutManager = GridLayoutManager(activity, 4)
        }
        rvPokemon.adapter = adapter
    }



    override fun onItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(pokemon: Pokemon?) {
        TODO("Not yet implemented")
    }


}