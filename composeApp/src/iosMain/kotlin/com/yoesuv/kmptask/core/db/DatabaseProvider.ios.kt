package com.yoesuv.kmptask.core.db

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.yoesuv.kmptask.getDatabaseBuilder
import com.yoesuv.kmptask.getRoomDatabase

@Composable
actual fun rememberMyTaskDao(): MyTaskDao {
    return remember {
        val db = getRoomDatabase(getDatabaseBuilder())
        db.myTaskDao()
    }
}
