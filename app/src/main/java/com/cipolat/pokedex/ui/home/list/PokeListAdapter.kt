package com.cipolat.pokedex.ui.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cipolat.pokedex.R
import com.cipolat.pokedex.data.model.Pokemon

class PokeListAdapter( private var list: List<Pokemon>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.pokemon_itm,
                viewGroup,
                false)
        return PokemonItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        val vh = viewHolder as PokemonItemViewHolder
        val prediction = list[i]
        vh.bindItem(prediction)
    }

    interface AddressClickListener {
       // fun onAddressClick(address: AutocompletePrediction)
    }
}
