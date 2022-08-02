package com.sebaahs.dexapp.data.model.dto

import com.google.gson.annotations.SerializedName


data class AbilityDTO (
    @SerializedName("name") val name : String,
    @SerializedName("url") val urlAbility: String
)

data class PokemonDTO(

    //-> URLS
    @SerializedName("url") val urlPokemonInfo: String,
    @SerializedName("location_area_encounters") val urlLocation: String,

    //-> DATA
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("abilities") val abilities: List<AbilityDTO>,
    @SerializedName("weight") val weight: Int
)