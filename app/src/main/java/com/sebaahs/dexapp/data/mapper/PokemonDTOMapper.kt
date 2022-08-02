package com.sebaahs.dexapp.data.mapper

import com.sebaahs.dexapp.data.model.Ability
import com.sebaahs.dexapp.data.model.Pokemon
import com.sebaahs.dexapp.data.model.PokemonEntry
import com.sebaahs.dexapp.data.model.dto.AbilityDTO
import com.sebaahs.dexapp.data.model.dto.PokemonDTO
import com.sebaahs.dexapp.data.remote.PokemonEntryDTO

class PokemonDTOMapper {

    fun pokemonListEntryDTOToPokemonListEntry(pokemonListEntryDTO: List<PokemonEntryDTO>): List<PokemonEntry> {
        return pokemonListEntryDTO.map { pokemonEntry ->
            pokemonEntryDTOToPokemonEntry(pokemonEntry)
        }
    }

    private fun pokemonEntryDTOToPokemonEntry(pokemonEntryDTO : PokemonEntryDTO): PokemonEntry {
        var n: String
        if (pokemonEntryDTO.url.endsWith("/"))
            n = pokemonEntryDTO.url.drop(1).takeLastWhile { it.isDigit() }
        else n = pokemonEntryDTO.url.takeLastWhile { it.isDigit() }

        return PokemonEntry(
            name = pokemonEntryDTO.name,
            url = pokemonEntryDTO.url,
            index = 0
        )
    }

    private fun pokemonDetailDTOToPokemonDetail(pokemonDTO : PokemonDTO): Pokemon {
        return Pokemon(
            id = pokemonDTO.id,
            name = pokemonDTO.name,
            baseExperience = pokemonDTO.baseExperience,
            ability = abilitiesDTOListToAbilitiesDomainList(pokemonDTO.abilities),
            weight = pokemonDTO.weight,
            urlPokemonInfo = pokemonDTO.urlPokemonInfo,
            urlLocation = pokemonDTO.urlLocation
        )
    }

    private fun abilitiesDTOToAbilitiesDomain(abilityDTO : AbilityDTO): Ability {
        return Ability(
            name = abilityDTO.name,
            urlAbility = abilityDTO.urlAbility
        )
    }

    private fun abilitiesDTOListToAbilitiesDomainList(abilities : List<AbilityDTO>) : List<Ability> {
        return abilities.map { abilities -> abilitiesDTOToAbilitiesDomain(abilities) }
    }

}