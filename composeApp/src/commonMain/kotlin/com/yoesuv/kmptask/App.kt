package com.yoesuv.kmptask

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yoesuv.kmptask.core.route.AppRoute
import com.yoesuv.kmptask.feature.home.HomeScreen
import com.yoesuv.kmptask.feature.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = AppRoute.Splash) {
            composable<AppRoute.Splash> {
                SplashScreen()
            }
            composable<AppRoute.Home> {
                HomeScreen()
            }
        }
    }
}