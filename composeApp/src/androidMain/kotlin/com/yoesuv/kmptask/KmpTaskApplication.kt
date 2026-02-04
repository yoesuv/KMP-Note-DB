package com.yoesuv.kmptask

import android.app.Application
import com.yoesuv.kmptask.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KmpTaskApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KmpTaskApplication)
            modules(appModule)
        }
    }
}
