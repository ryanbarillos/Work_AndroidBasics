package com.example.artspace.data

import com.example.artspace.R
import com.example.artspace.model.Art

object Datasource {
    val arts = listOf(
        Art(artPhoto = R.drawable.toy_dog, artTitle = R.string.toy_dog, artAuthor = R.string.author, artYear = 2020),
        Art(artPhoto = R.drawable.toy_car, artTitle = R.string.toy_car, artAuthor = R.string.author, artYear = 2020),
        Art(artPhoto = R.drawable.statue_defiant, artTitle = R.string.statue_defiant, artAuthor = R.string.author, artYear = 2024),
    )
}