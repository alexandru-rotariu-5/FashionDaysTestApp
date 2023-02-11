package com.example.fashiondaystestapp.data.network

import com.example.fashiondaystestapp.data.models.ProductsResponse
import retrofit2.http.GET

interface ProductsAPI {

    @GET("/mobile/8/g/women/clothing/")
    suspend fun getProducts() : ProductsResponse
}