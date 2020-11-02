package com.cipolat.pokedex.data.repository

import com.cipolat.pokedex.data.api.service.ApiInteractor

class PokeRepository(var interactor: ApiInteractor) {

    suspend fun getPokemons() = interactor.getPokemonsFromApi()

}