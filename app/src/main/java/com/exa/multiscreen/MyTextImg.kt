package com.exa.multiscreen

class MyTextImg(private val english: String, private val miwok: String, val audio:Int) {

    var image: Int? = null

    constructor(english: String, miwok: String, image: Int, audio: Int) : this(english, miwok, audio) {
        this.image = image
    }

    fun get_English(): String {
        return english
    }

    fun get_Miwok(): String = miwok

    fun get_Image(): Int? = image

    fun get_Audio(): Int = audio

    fun hasImage(): Boolean = image != null
}