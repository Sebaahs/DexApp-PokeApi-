package com.sebaahs.dexapp.data.model

data class Ability (
    val name : String,
    val urlAbility: String
)

data class Pokemon(
    //-> DATA
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val ability: List<Ability>,
    val weight: Int,
    //-> URLS
    val urlPokemonInfo: String,
    val urlLocation: String
)

