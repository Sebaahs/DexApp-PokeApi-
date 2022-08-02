package com.sebaahs.dexapp.provider.core

import com.sebaahs.dexapp.data.model.Pokemon
import com.sebaahs.dexapp.data.model.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun  getAllPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun  getPokemonsInfo(
        @Path("name") name: String
    ): Pokemon
}