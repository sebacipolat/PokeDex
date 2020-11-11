package com.cipolat.pokedex.ui.home.list

import com.cipolat.pokedex.ui.util.removeLastChar

fun String.getPokeImage(): String {
    val cleanUrl = this.removeLastChar()
    cleanUrl?.let {
        var indexPokemon = cleanUrl.substring(cleanUrl.lastIndexOf("/") + 1, cleanUrl.length)
        val number = String.format("%03d", indexPokemon.toInt())
        return "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$number.png"
    }?: run {
        return this
    }

}
