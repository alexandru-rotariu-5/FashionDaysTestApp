package com.example.fashiondaystestapp

import android.app.Application
import com.example.fashiondaystestapp.di.AppComponent
import com.example.fashiondaystestapp.di.AppModule
import com.example.fashiondaystestapp.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    private fun initDagger(app: App): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }


}