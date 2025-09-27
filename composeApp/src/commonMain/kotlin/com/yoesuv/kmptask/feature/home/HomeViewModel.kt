package com.yoesuv.kmptask.feature.home

import com.yoesuv.kmptask.core.db.MyTaskDao
import com.yoesuv.kmptask.core.models.MyTaskModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val dao: MyTaskDao
) {
    private val scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    // Expose Room Flow as StateFlow for UI consumption
    val tasks: StateFlow<List<MyTaskModel>> =
        dao.getAll().stateIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun addTask(title: String, content: String) {
        val trimmedTitle = title.trim()
        val trimmedContent = content.trim()
        if (trimmedTitle.isEmpty() || trimmedContent.isEmpty()) return
        scope.launch {
            dao.insert(
                MyTaskModel(
                    title = trimmedTitle,
                    description = trimmedContent
                )
            )
        }
    }

    fun deleteAll() {
        scope.launch {
            dao.deleteAll()
        }
    }
}
