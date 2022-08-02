package com.sebaahs.dexapp.api

import com.sebaahs.dexapp.provider.core.PokeApi
import com.sebaahs.dexapp.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit = Retrofit.Builder()
.baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object PokemonsApi {
    val retrofitService: PokeApi by lazy {
        retrofit.create(PokeApi::class.java)
    }
}