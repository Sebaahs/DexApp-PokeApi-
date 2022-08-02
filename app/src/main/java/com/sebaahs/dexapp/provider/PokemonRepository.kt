package com.sebaahs.dexapp.provider

import com.sebaahs.dexapp.api.PokemonsApi.retrofitService
import com.sebaahs.dexapp.provider.core.makeNetworkCall
import com.sebaahs.dexapp.data.mapper.PokemonDTOMapper
import com.sebaahs.dexapp.data.model.PokemonEntry
import com.sebaahs.dexapp.util.ResourceStatus

class PokemonRepository {

    suspend fun downloadPokemons(limit: Int, offset: Int) : ResourceStatus<List<PokemonEntry>> = makeNetworkCall {
            val pokemonDTOList = retrofitService.getAllPokemons(limit, offset).pokemons
            val pokemonDTOMapper = PokemonDTOMapper()
            pokemonDTOMapper.pokemonListEntryDTOToPokemonListEntry(pokemonDTOList)
        }
    }