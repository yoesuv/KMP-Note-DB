package com.yoesuv.kmptask.core.db

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.yoesuv.kmptask.getDatabaseBuilder
import com.yoesuv.kmptask.getRoomDatabase
import com.yoesuv.kmptask.AppDatabase

@Composable
actual fun rememberAppDatabase(): AppDatabase {
    val context = LocalContext.current
    return remember(context) {
        getRoomDatabase(getDatabaseBuilder(context))
    }
}
