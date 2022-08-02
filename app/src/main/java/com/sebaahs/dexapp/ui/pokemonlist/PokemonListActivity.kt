package com.sebaahs.dexapp.ui.pokemonlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebaahs.dexapp.databinding.ActivityPokemonListBinding
import com.sebaahs.dexapp.ui.pokemondetail.PokeDetailActivity
import com.sebaahs.dexapp.ui.pokemondetail.PokeDetailActivity.Companion.POKEMON_KEY
import com.sebaahs.dexapp.util.ResourceStatus

class PokemonListActivity : AppCompatActivity() {

    private val pokemonListViewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWeel = binding.loadingWheel
        val recyclerView = binding.pokemonListRecycler
        val adapter = PokemonListAdapter()

        adapter.setOnItemClickListener { pokemon ->
            val goToDetail = Intent(this@PokemonListActivity, PokeDetailActivity::class.java)
            goToDetail.putExtra(POKEMON_KEY, pokemon.url)
            startActivity(goToDetail)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        pokemonListViewModel.status.observe(this) { status ->
            when(status) {
                is ResourceStatus.Loading -> loadingWeel.visibility = View.VISIBLE
                is ResourceStatus.Error -> {
                    loadingWeel.visibility = View.GONE
                    Toast.makeText(this@PokemonListActivity, status.message, Toast.LENGTH_SHORT).show()
                }
                is ResourceStatus.Success -> loadingWeel.visibility = View.GONE
            }
        }

        pokemonListViewModel.pokemonlist.observe(this) { pokemonList ->
            adapter.submitList(pokemonList)
        }
    }
}