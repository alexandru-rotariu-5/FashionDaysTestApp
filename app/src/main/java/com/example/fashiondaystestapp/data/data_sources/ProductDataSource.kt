package com.example.fashiondaystestapp.data.data_sources

import com.example.fashiondaystestapp.data.models.ProductsResponse
import com.example.fashiondaystestapp.data.network.APIService
import retrofit2.Response
import javax.inject.Inject

class ProductDataSource @Inject constructor(private val apiService: APIService) {

    suspend fun getProducts(): Response<ProductsResponse> {
        return apiService.getProducts()
    }
}