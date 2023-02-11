package com.example.fashiondaystestapp.data.data_sources

import com.example.fashiondaystestapp.data.models.ProductsResponse
import com.example.fashiondaystestapp.data.network.APIService
import com.example.fashiondaystestapp.data.network.APIClient
import retrofit2.Response

class ProductDataSource {

    private val apiService = APIClient.retrofit.create(APIService::class.java)

    suspend fun getProducts(): Response<ProductsResponse> {
        return apiService.getProducts()
    }
}