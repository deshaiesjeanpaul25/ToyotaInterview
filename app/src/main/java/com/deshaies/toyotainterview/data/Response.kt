package com.deshaies.toyotainterview.data

import com.google.gson.annotations.SerializedName

data class Response(

    @SerializedName("products" ) var products : ArrayList<Product> = arrayListOf(),
    @SerializedName("total"    ) var total    : Int?                = null,
    @SerializedName("skip"     ) var skip     : Int?                = null,
    @SerializedName("limit"    ) var limit    : Int?                = null
)
