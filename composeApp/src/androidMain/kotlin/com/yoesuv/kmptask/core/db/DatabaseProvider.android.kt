package com.yoesuv.kmptask.core.db

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.yoesuv.kmptask.getDatabaseBuilder
import com.yoesuv.kmptask.getRoomDatabase

@Composable
actual fun rememberMyTaskDao(): MyTaskDao {
    val context = LocalContext.current
    return remember(context) {
        val db = getRoomDatabase(getDatabaseBuilder(context))
        db.myTaskDao()
    }
}
