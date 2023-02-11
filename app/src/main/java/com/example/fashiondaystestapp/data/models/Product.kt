package com.example.fashiondaystestapp.data.models

import com.example.fashiondaystestapp.ui.models.ProductItem
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("product_id") val id: Int,
    @SerializedName("product_brand") val brand: String,
    @SerializedName("product_name") val name: String,
    @SerializedName("product_images") val images: ProductImageList
) {
    fun toProductItem(): ProductItem {
        return ProductItem(
            brand, name, images.thumb[0]
        )
    }
}
