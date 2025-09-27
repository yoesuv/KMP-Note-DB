package com.yoesuv.kmptask.core.db

import androidx.compose.runtime.Composable

// Expect/Actual composable to provide a MyTaskDao instance per platform.
// The actual implementations will build the database with the proper builder
// and return the DAO. Using @Composable allows us to remember/cache the instance.
@Composable
expect fun rememberMyTaskDao(): MyTaskDao
