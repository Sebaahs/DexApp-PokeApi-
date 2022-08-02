package com.sebaahs.dexapp.data.remote

import com.google.gson.annotations.SerializedName

data class PokemonEntryDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
