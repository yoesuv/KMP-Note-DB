package com.yoesuv.kmptask.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.yoesuv.kmptask.core.models.MyTaskModel
import com.yoesuv.kmptask.core.theme.AppColors
import com.yoesuv.kmptask.feature.components.AppButton
import com.yoesuv.kmptask.feature.components.AppButtonStyle
import org.jetbrains.compose.resources.stringResource
import kmpmytask.composeapp.generated.resources.Res
import kmpmytask.composeapp.generated.resources.delete_task
import kmpmytask.composeapp.generated.resources.edit_task

@Composable
fun DialogTaskOptions(
    task: MyTaskModel?,
    onDismiss: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            // Title section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = AppColors.Pink500,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    )
            ) {
                Text(
                    text = task?.title ?: "",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    maxLines = 1
                )
            }

            // Content section with task title and buttons in a column
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppButton(
                    text = stringResource(Res.string.edit_task),
                    style = AppButtonStyle.Bordered,
                    onClick = onEdit,
                    modifier = Modifier.fillMaxWidth()
                )
                AppButton(
                    text = stringResource(Res.string.delete_task),
                    style = AppButtonStyle.Bordered,
                    onClick = onDelete,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
