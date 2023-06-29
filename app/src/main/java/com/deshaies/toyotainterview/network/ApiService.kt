package com.deshaies.toyotainterview.network

import com.deshaies.toyotainterview.data.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): Response<com.deshaies.toyotainterview.data.Response>
}