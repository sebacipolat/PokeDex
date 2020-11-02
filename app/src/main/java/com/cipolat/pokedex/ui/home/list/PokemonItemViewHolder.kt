package com.cipolat.pokedex.ui.home.list

import android.R
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
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
        view.name_lbl.text = pokemon.name.capitalize()
        Glide.with(view.context).load(pokemon.url.getPokeImage()).into(object :
            CustomTarget<Drawable>() {
            override fun onLoadCleared(placeholder: Drawable?) {
            }

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                view.icon.setImageDrawable(resource)
                Palette.from(resource.toBitmap()).generate { p ->
                    val color: Int? = p?.getLightVibrantColor(
                        ContextCompat.getColor(
                            view.context,
                            R.color.darker_gray
                        )
                    )
                    color?.let { view.card.setCardBackgroundColor(it) }
                }
            }
        })
    }

    override fun onClick(view: View?) {
        //callback.onAddressClick(prediction)
    }

}
