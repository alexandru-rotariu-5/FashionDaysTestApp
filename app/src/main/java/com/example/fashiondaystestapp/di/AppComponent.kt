package com.example.fashiondaystestapp.di

import com.example.fashiondaystestapp.ui.product_list.ProductListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(target: ProductListFragment)
}
