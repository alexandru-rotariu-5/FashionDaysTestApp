package com.example.fashiondaystestapp.data.repositories

import com.example.fashiondaystestapp.data.data_sources.ProductDataSource
import com.example.fashiondaystestapp.data.models.ProductsResponse
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDataSource: ProductDataSource) {

    suspend fun getProducts(): ProductsResponse? {
        val request = productDataSource.getProducts()

        if (request.isSuccessful) {
            return request.body()!!
        }

        return null
    }
}