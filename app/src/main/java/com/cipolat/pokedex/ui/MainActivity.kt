package com.cipolat.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.cipolat.pokedex.R
import com.cipolat.pokedex.data.api.HttpClient
import com.cipolat.pokedex.data.api.service.ApiInteractor
import com.cipolat.pokedex.data.model.Pokemon
import com.cipolat.pokedex.ui.home.viewmodel.HomeViewModel
import com.cipolat.pokedex.ui.home.viewmodel.ViewModelFactory
import com.facebook.stetho.Stetho
import com.cipolat.pokedex.ui.home.list.PokeListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: PokeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this);


        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiInteractor(HttpClient.apiService))
        ).get(HomeViewModel::class.java)

        viewModel.giveMePokemons().observe(this, Observer {
            it?.let {
                Log.e("pokemones","===>"+it.results.size)
                fillView(it.results)
            }
        })
    }
    private fun fillView(list:List<Pokemon>){
        listRecycler.layoutManager = GridLayoutManager(this,2)
        adapter = PokeListAdapter(list)
        listRecycler.adapter = adapter
    }
}