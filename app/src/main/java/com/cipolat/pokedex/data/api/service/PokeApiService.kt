package com.cipolat.pokedex.data.api.service

import com.cipolat.pokedex.data.model.PokeListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokeApiService {
    @GET("pokemon?offset=0&limit=20")
    suspend fun getPokemonList(): Response<PokeListResponse>
}