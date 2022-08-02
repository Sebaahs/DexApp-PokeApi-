package com.sebaahs.dexapp.ui.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebaahs.dexapp.data.model.Pokemon
import com.sebaahs.dexapp.data.model.PokemonEntry
import com.sebaahs.dexapp.provider.PokemonRepository
import com.sebaahs.dexapp.util.PAGE_SIZE
import com.sebaahs.dexapp.util.ResourceStatus
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonEntry>>()
    val pokemonlist: LiveData<List<PokemonEntry>>
        get() = _pokemonList

    private val _status = MutableLiveData<ResourceStatus<List<PokemonEntry>>>()
    val status: LiveData<ResourceStatus<List<PokemonEntry>>>
        get() = _status

    private val currentPage = 1

    //TODO: MANAGE PAGES

    private val pokemonRepository = PokemonRepository()


    init {
        downloadPokemons()
    }

    private fun downloadPokemons() = viewModelScope.launch {
            _status.value = ResourceStatus.Loading()
            handleResponseStatus(pokemonRepository.downloadPokemons(PAGE_SIZE, currentPage * PAGE_SIZE))
        }

    //private fun downloadPokemonInfo(name: String) = viewModelScope.;

    private fun handleResponseStatus(res : ResourceStatus<List<PokemonEntry>>) {
        if (res is ResourceStatus.Success) {
            _pokemonList.value = res.data
            //TODO: IMGS
        }
        _status.value = res
    }
}