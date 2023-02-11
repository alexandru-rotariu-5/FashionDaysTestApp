package com.example.fashiondaystestapp.data.network

import com.example.fashiondaystestapp.data.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {

    @Headers("x-mobile-app-locale: ro_RO")
    @GET("/mobile/8/g/women/clothing/")
    suspend fun getProducts() : Response<ProductsResponse>
}