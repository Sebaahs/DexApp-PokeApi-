package com.sebaahs.dexapp.ui.pokemonlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sebaahs.dexapp.data.model.Pokemon
import com.sebaahs.dexapp.data.model.PokemonEntry
import com.sebaahs.dexapp.databinding.PokemonListItemBinding

class PokemonListAdapter : ListAdapter<PokemonEntry, PokemonListAdapter.PokemonViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<PokemonEntry>(){
        override fun areItemsTheSame(oldItem : PokemonEntry, newItem : PokemonEntry) : Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem : PokemonEntry, newItem : PokemonEntry) : Boolean = oldItem.index == newItem.index
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : PokemonViewHolder {
        return PokemonViewHolder(
            PokemonListItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    private var onItemClickListener: ((PokemonEntry) -> Unit)? = null

    fun setOnItemClickListener (onItemClickListener : (PokemonEntry) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onBindViewHolder(holder : PokemonViewHolder, position : Int) = holder.bind(getItem(position))

    inner class PokemonViewHolder (val binding: PokemonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: PokemonEntry) {
            binding.pokemonListItemName.text = pokemon.name
            binding.pokemonListItemName.setOnClickListener {
                onItemClickListener?.invoke(pokemon)
            }

            //Glide.with(context)
              //  .load()
                //.into(binding.pokemonListItemImg)
        }
    }

}