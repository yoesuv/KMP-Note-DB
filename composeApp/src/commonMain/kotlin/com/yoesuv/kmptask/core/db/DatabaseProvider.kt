package com.yoesuv.kmptask.core.db

import androidx.compose.runtime.Composable
import com.yoesuv.kmptask.AppDatabase

// New: Provide the full Room database so multiple DAOs can be accessed from one source.
// This mirrors the approach in the official KMP Room docs where you inject the database
// and then access the DAOs as needed.
@Composable
expect fun rememberAppDatabase(): AppDatabase
