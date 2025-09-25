package com.yoesuv.kmptask.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yoesuv.kmptask.core.theme.AppColors
import com.yoesuv.kmptask.feature.components.AppTopBar
import kmpmytask.composeapp.generated.resources.Res
import kmpmytask.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(Res.string.app_name),
                canBack = false,
                trailingIcon = Icons.Default.Delete,
                onTrailingIconClick = { /* TODO: delete all function */ }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home Screen")
        }
    }

    if (showDialog) {
        DialogAddEditTask(
            onDismiss = { showDialog = false },
            onConfirm = { title, content ->
                // TODO: Handle adding the task
                println("Adding task: $title - $content")
                showDialog = false
            }
        )
    }
}