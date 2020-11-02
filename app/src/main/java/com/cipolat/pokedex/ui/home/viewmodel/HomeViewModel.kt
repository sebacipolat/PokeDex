package com.cipolat.pokedex.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.cipolat.pokedex.data.repository.PokeRepository
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val repository: PokeRepository) : ViewModel() {

    fun giveMePokemons() = liveData(Dispatchers.IO) {
        val response = repository.getPokemons()
        emit(response.body())
    }
}