package com.cipolat.pokedex.ui.home.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cipolat.pokedex.data.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_itm.view.*

class PokemonItemViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var view: View = itemView
    private lateinit var pokemon: Pokemon

    init {
        view.setOnClickListener(this)
    }

    fun bindItem(pokemon: Pokemon) {
        this.pokemon = pokemon
        view.name_lbl.text=pokemon.name.capitalize()
        Glide.with(view.context).load(pokemon.url.getPokeImage()).into(view.icon);
    }

    override fun onClick(view: View?) {
        //callback.onAddressClick(prediction)
    }


}
