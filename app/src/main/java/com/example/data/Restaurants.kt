package com.example.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurants (
    val count: Int,
    val per_page: Int,
    val current_page: Int,
    val restaurants: List<Restaurant>
):Parcelable