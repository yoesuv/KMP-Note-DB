package com.yoesuv.kmptask

import androidx.compose.ui.window.ComposeUIViewController
import com.yoesuv.kmptask.di.appModule
import org.koin.core.context.startKoin

private val koinApp by lazy {
    startKoin {
        modules(appModule)
    }
}

private fun initKoin() {
    koinApp
}

fun MainViewController() = ComposeUIViewController {
    App()
}.also { initKoin() }
