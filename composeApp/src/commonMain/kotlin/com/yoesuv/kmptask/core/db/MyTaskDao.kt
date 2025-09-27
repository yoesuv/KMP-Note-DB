package com.yoesuv.kmptask.core.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.yoesuv.kmptask.core.models.MyTaskModel

@Dao
interface MyTaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: MyTaskModel)
}