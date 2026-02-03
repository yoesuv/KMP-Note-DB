package com.yoesuv.kmptask

import androidx.compose.ui.window.ComposeUIViewController
import com.yoesuv.kmptask.di.appModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { 
    startKoin {
        modules(appModule)
    }
    App() 
}