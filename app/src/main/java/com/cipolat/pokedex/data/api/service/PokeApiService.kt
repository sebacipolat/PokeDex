package com.cipolat.pokedex.data.api.service

import com.cipolat.pokedex.data.model.PokeListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokeApiService {

    //@GET("659490f5-bb05-408d-8798-e8d4cd70b6aa")
    @GET("pokemon?offset=0&limit=20")
    suspend fun getPokemonList(): Response<PokeListResponse>
}
