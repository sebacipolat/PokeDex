package com.cipolat.pokedex.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cipolat.pokedex.data.api.service.ApiInteractor
import com.cipolat.pokedex.data.repository.PokeRepository

class ViewModelFactory(private val apiHelper: ApiInteractor) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(PokeRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}