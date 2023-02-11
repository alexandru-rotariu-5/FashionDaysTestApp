package com.example.fashiondaystestapp.ui.product_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fashiondaystestapp.data.repositories.ProductRepository
import com.example.fashiondaystestapp.ui.models.ProductItem
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private val _products = MutableLiveData<ArrayList<ProductItem>>()
    val products: LiveData<ArrayList<ProductItem>> = _products

    init {
        loadProducts()
    }

    private fun loadProducts() {

        viewModelScope.launch {
            val response = productRepository.getProducts()
            if (response != null) {
                _products.value = response.toProductItemList()
            }
        }
    }
}