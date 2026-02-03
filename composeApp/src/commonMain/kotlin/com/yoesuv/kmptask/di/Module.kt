package com.yoesuv.kmptask.di

import com.yoesuv.kmptask.AppDatabase
import com.yoesuv.kmptask.core.db.MyTaskDao
import com.yoesuv.kmptask.feature.home.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

expect val platformModule: Module

val appModule = module {
    includes(platformModule)
    
    single<MyTaskDao> { get<AppDatabase>().myTaskDao() }
    
    viewModel { HomeViewModel(get()) }
}