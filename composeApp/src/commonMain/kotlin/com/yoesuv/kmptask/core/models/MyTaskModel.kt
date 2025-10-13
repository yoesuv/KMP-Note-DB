package com.yoesuv.kmptask.core.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyTaskModel(
    @PrimaryKey(autoGenerate = true) var idTask: Long = 0,
    var title: String,
    var description: String,
)