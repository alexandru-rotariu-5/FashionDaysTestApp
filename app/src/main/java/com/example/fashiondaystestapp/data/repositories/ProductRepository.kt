package com.example.fashiondaystestapp.data.repositories

import com.example.fashiondaystestapp.data.data_sources.ProductDataSource
import com.example.fashiondaystestapp.data.models.ProductsResponse

class ProductRepository {

    private val productDataSource = ProductDataSource()

    suspend fun getProducts(): ProductsResponse? {
        val request = productDataSource.getProducts()

        if (request.isSuccessful) {
            return request.body()!!
        }

        return null
    }
}