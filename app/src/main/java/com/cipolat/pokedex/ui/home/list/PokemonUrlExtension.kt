package com.cipolat.pokedex.ui.home.list

fun String.getPokeImage():String{
    val imgIndex=this.lastIndexOf("/")-1
    val img= (this[imgIndex].toString()).toInt()
    val number=String.format("%03d", img)
    return "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$number.png"
}



