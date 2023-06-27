package com.example.interestspage

import androidx.annotation.DrawableRes

data class InterestItem(
    val text: String,
    @DrawableRes
    val icon: Int,
    var isSelected: Boolean = false
)
