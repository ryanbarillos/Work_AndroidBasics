package com.example.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Art(
    val artYear: Int,

    @StringRes
    val artTitle: Int,
    val artAuthor: Int,

    @DrawableRes
    val artPhoto: Int,
)
