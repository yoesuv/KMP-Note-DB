package com.yoesuv.kmptask.core.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yoesuv.kmptask.core.models.MyTaskModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MyTaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: MyTaskModel)

    @Update
    suspend fun update(task: MyTaskModel)

    @Delete
    suspend fun delete(task: MyTaskModel)

    @Query("SELECT * FROM MyTaskModel")
    fun getAll(): Flow<List<MyTaskModel>>

    @Query("SELECT * FROM MyTaskModel WHERE idTask = :id")
    suspend fun getById(id: Long): MyTaskModel?

    @Query("DELETE FROM MyTaskModel")
    suspend fun deleteAll()
}