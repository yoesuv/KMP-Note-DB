package com.yoesuv.kmptask.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.kmptask.core.db.MyTaskDao
import com.yoesuv.kmptask.core.models.MyTaskModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val dao: MyTaskDao
): ViewModel() {

    // Expose Room Flow as StateFlow for UI consumption
    val tasks: StateFlow<List<MyTaskModel>> =
        dao.getAll().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun addTask(title: String, content: String) {
        val trimmedTitle = title.trim()
        val trimmedContent = content.trim()
        if (trimmedTitle.isEmpty() || trimmedContent.isEmpty()) return
        viewModelScope.launch {
            dao.insert(
                MyTaskModel(
                    title = trimmedTitle,
                    description = trimmedContent
                )
            )
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            dao.deleteAll()
        }
    }

    fun deleteTask(task: MyTaskModel) {
        viewModelScope.launch {
            dao.delete(task)
        }
    }
}

