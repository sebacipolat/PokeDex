package com.cipolat.pokedex.home.list

import com.cipolat.pokedex.ui.home.list.getPokeImage
import org.junit.Assert
import org.junit.Test

class PokemonUrlExtensionTest {
    @Test
    fun addition_isCorrect() {
        val url="https://pokeapi.co/api/v2/language/12/"
        val expectedUrl="https://assets.pokemon.com/assets/cms2/img/pokedex/detail/012.png"
        val newUrl=url.getPokeImage()
        Assert.assertEquals(newUrl, expectedUrl)
    }
}