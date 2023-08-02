package com.example.koinbasicstructure

import android.app.Application
import com.example.koinbasicstructure.di.apiModules
import com.example.koinbasicstructure.di.domainModules
import com.example.koinbasicstructure.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationActivity : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin { androidLogger()
            androidContext(this@ApplicationActivity)
            modules(listOf(
                apiModules,
                domainModules,
                viewModelModule
            )) }
    }
}