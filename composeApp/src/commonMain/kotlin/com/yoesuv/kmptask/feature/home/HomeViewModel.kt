package com.yoesuv.kmptask.feature.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.yoesuv.kmptask.core.models.MyTaskModel

class HomeViewModel {
    val tasks: SnapshotStateList<MyTaskModel> = mutableStateListOf()

    init {
        tasks.addAll(
            listOf(
                MyTaskModel(
                    idTask = 1,
                    title = "Buy groceries",
                    description = "Milk, eggs, bread, and fruits"
                ),
                MyTaskModel(
                    idTask = 2,
                    title = "Workout",
                    description = "Evening run for 30 minutes"
                ),
                MyTaskModel(
                    idTask = 3,
                    title = "Read a book",
                    description = "Continue reading the Kotlin Coroutines chapter"
                ),
                MyTaskModel(
                    idTask = 4,
                    title = "Call mom",
                    description = "Catch up and plan weekend visit"
                ),
                MyTaskModel(
                    idTask = 5,
                    title = "Prepare presentation",
                    description = "Draft slides for Monday's meeting"
                )
            )
        )
    }
}
