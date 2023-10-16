package com.example.utsdelvino.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MatKul (
    @StringRes val nameRes: Int,
    @StringRes val sksRes: Int,
    @DrawableRes val imageRes: Int
)