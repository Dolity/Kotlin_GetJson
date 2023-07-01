package com.example.coffee_jsonapi_retrofitrx

import com.google.gson.annotations.SerializedName

class coffe (
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail:String,
    @SerializedName("content") val content: String
)
