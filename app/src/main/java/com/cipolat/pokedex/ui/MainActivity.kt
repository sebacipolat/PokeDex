package com.cipolat.pokedex.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.cipolat.pokedex.R
import com.cipolat.pokedex.data.api.HttpClient
import com.cipolat.pokedex.data.api.model.Resource
import com.cipolat.pokedex.data.api.model.Status
import com.cipolat.pokedex.data.api.service.ApiInteractor
import com.cipolat.pokedex.data.model.PokeListResponse
import com.cipolat.pokedex.data.model.Pokemon
import com.cipolat.pokedex.ui.home.viewmodel.HomeViewModel
import com.cipolat.pokedex.ui.home.viewmodel.ViewModelFactory
import com.facebook.stetho.Stetho
import com.cipolat.pokedex.ui.home.list.PokeListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

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

        viewModel.giveMePokemons().observe(this, observerResponse)
    }

    private  var observerResponse = Observer<Resource<Response<PokeListResponse>>> {
        when (it.status) {
            Status.SUCCESS -> it.data?.body()?.results?.let { it1 -> fillView(it1) }
            Status.ERROR -> it.message?.let { it1 -> showError(it1) }
        }
    }

    private fun showError(msg:String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
    private fun fillView(list: List<Pokemon>) {
        loader.visibility= View.GONE
        listRecycler.visibility= View.VISIBLE
        listRecycler.layoutManager = GridLayoutManager(this, 2)
        adapter = PokeListAdapter(list)
        listRecycler.adapter = adapter
    }
}