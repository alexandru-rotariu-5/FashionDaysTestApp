package com.example.fashiondaystestapp.data.models

import com.example.fashiondaystestapp.ui.models.ProductItem
import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("products")
    val products: ArrayList<Product>
) {
    fun toProductItemList() : ArrayList<ProductItem> {
        return ArrayList(products.map { p -> p.toProductItem() })
    }
}