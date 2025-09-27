package com.yoesuv.kmptask

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.yoesuv.kmptask.core.data.Constants
import com.yoesuv.kmptask.core.db.MyTaskDao
import com.yoesuv.kmptask.core.models.MyTaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [MyTaskModel::class], version = Constants.DATABASE_VERSION)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myTaskDao(): MyTaskDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}


fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
