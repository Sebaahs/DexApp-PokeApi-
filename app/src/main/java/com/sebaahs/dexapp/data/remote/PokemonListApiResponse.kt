package com.sebaahs.dexapp.data.model.response
import com.google.gson.annotations.SerializedName
import com.sebaahs.dexapp.data.remote.PokemonEntryDTO

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val pokemons: List<PokemonEntryDTO>
    )