package com.cipolat.pokedex.data.repository

import com.cipolat.pokedex.data.api.ResponseHandler
import com.cipolat.pokedex.data.api.model.Resource
import com.cipolat.pokedex.data.api.service.ApiInteractor
import com.cipolat.pokedex.data.model.PokeListResponse
import retrofit2.Response

class PokeRepository(var interactor: ApiInteractor) {
    private val responseHandler= ResponseHandler()

    suspend fun getPokemons():Resource<Response<PokeListResponse>>{
        return try {
            return responseHandler.handleSuccess(interactor.getPokemonsFromApi())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}