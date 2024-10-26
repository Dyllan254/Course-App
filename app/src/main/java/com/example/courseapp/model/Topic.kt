package com.example.courseapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val courseNumberId : Int,
    @DrawableRes val imageResourceId : Int,

)