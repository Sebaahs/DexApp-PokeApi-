package com.sebaahs.dexapp.ui.pokemondetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sebaahs.dexapp.databinding.ActivityPokeDetailBinding
import com.sebaahs.dexapp.data.model.Pokemon

class PokeDetailActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_KEY = "pokemon_url"
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPokeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pokemon = intent?.extras?.getString(POKEMON_KEY)
        if (pokemon == null) {
            Toast.makeText(this@PokeDetailActivity, "Pokemon not found", Toast.LENGTH_SHORT)
            finish()
            return
        }
        //TODO
         //binding.pokemon = pokemon
    }
}