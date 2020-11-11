package com.cipolat.pokedex.ui.util

fun String.removeLastChar(): String? {
    return removeLastChars(this, 1)
}

fun removeLastChars(str: String, chars: Int): String? {
    return str.substring(0, str.length - chars)
}