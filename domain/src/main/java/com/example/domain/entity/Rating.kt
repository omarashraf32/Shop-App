package com.example.domain.entity


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("rate")
    val rate: Double? = null
)