package com.yoesuv.kmptask.di

import com.yoesuv.kmptask.AppDatabase
import com.yoesuv.kmptask.getDatabaseBuilder
import com.yoesuv.kmptask.getRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformModule = module {
    single<AppDatabase> { 
        getRoomDatabase(getDatabaseBuilder(androidContext()))
    }
}
