package com.yoesuv.kmptask

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yoesuv.kmptask.core.data.Constants

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(Constants.DATABASE_NAME)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
