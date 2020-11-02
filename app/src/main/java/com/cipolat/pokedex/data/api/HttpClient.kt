package com.cipolat.pokedex.data.api

import com.cipolat.pokedex.BuildConfig
import com.cipolat.pokedex.data.api.service.PokeApiService
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {
    private fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
    val apiService: PokeApiService = getRetrofit().create(
        PokeApiService::class.java)
}