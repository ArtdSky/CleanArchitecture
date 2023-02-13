package com.example.cleanarchitecture.app

import android.app.Application
import com.example.cleanarchitecture.di.AppComponent
import com.example.cleanarchitecture.di.AppModule
import com.example.cleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }


}