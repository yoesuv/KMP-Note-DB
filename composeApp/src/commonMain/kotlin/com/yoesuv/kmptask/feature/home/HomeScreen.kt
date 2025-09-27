package com.yoesuv.kmptask.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yoesuv.kmptask.core.db.rememberAppDatabase
import com.yoesuv.kmptask.core.theme.AppColors
import com.yoesuv.kmptask.feature.components.AppTopBar
import kmpmytask.composeapp.generated.resources.Res
import kmpmytask.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    val db = rememberAppDatabase()
    val dao = remember(db) { db.myTaskDao() }
    val viewModel = remember(dao) { HomeViewModel(dao) }
    val tasks by viewModel.tasks.collectAsState()
    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(Res.string.app_name),
                canBack = false,
                trailingIcon = Icons.Default.Delete,
                onTrailingIconClick = { showDeleteDialog = true }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = AppColors.Pink500,
                onClick = { showDialog = true }) {
                Icon(Icons.Filled.Add, contentDescription = "Add task", tint = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(tasks) { task ->
                ItemTask(myTask = task)
                HorizontalDivider()
            }
        }
    }

    if (showDialog) {
        DialogAddEditTask(
            onDismiss = { showDialog = false },
            onConfirm = { title, content ->
                viewModel.addTask(title, content)
                showDialog = false
            }
        )
    }

    if (showDeleteDialog) {
        DialogDeleteAll(
            onDismiss = { showDeleteDialog = false },
            onConfirm = {
                viewModel.deleteAll()
                showDeleteDialog = false
            }
        )
    }
}