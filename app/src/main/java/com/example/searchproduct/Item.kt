package com.example.searchproduct

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
    data class Item(
        val id: String,
        val title: String,
        @DrawableRes val image: Int,
        val description: String
    ) : Parcelable

