package com.yoesuv.kmptask.core.db

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.yoesuv.kmptask.getDatabaseBuilder
import com.yoesuv.kmptask.getRoomDatabase
import com.yoesuv.kmptask.AppDatabase

@Composable
actual fun rememberAppDatabase(): AppDatabase {
    return remember {
        getRoomDatabase(getDatabaseBuilder())
    }
}
