package com.example.fashiondaystestapp.ui.product_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashiondaystestapp.data.repositories.ProductRepository
import com.example.fashiondaystestapp.ui.models.ProductItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>> = _products

    init {
        loadProducts()
    }

    private fun loadProducts(callback: () -> Unit = {}) {
        viewModelScope.launch {
            val response = productRepository.getProducts()
            if (response != null) {
                Log.d("Products response", response.toProductItemList().toString())
                _products.value = response.toProductItemList()
                callback()
            }
        }
    }

    fun updateProducts(callback: () -> Unit) {
        loadProducts(callback)
    }
}