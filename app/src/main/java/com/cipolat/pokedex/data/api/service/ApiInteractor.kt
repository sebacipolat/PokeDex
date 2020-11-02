package com.cipolat.pokedex.data.api.service


class ApiInteractor(var service: PokeApiService) {

    suspend fun getPokemonsFromApi() = service.getPokemonList()

}