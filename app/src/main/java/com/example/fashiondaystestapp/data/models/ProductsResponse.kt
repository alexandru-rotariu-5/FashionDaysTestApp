package com.example.fashiondaystestapp.data.models

import com.example.fashiondaystestapp.ui.models.ProductItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsResponse(
    @Json(name = "products")
    val products: List<Product>
) {
    fun toProductItemList() : List<ProductItem> {
        return ArrayList(products.map { p -> p.toProductItem() })
    }
}