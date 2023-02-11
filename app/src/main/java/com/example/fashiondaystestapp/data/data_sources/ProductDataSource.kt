package com.example.fashiondaystestapp.data.data_sources

import com.example.fashiondaystestapp.data.models.ProductsResponse
import com.example.fashiondaystestapp.data.network.ProductsAPI
import com.example.fashiondaystestapp.data.network.RetrofitHelper

class ProductDataSource {

    private val productsAPI: ProductsAPI = RetrofitHelper.getInstance().create(ProductsAPI::class.java)

    suspend fun getProducts(): ProductsResponse {
        return productsAPI.getProducts()
    }
}