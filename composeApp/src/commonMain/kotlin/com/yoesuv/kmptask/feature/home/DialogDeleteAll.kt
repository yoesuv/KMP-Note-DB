package com.yoesuv.kmptask.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.yoesuv.kmptask.core.theme.AppColors
import kmpmytask.composeapp.generated.resources.Res
import kmpmytask.composeapp.generated.resources.cancel
import kmpmytask.composeapp.generated.resources.delete
import kmpmytask.composeapp.generated.resources.delete_all
import kmpmytask.composeapp.generated.resources.delete_all_tasks
import org.jetbrains.compose.resources.stringResource
import com.yoesuv.kmptask.feature.components.AppButton
import com.yoesuv.kmptask.feature.components.AppButtonStyle

@Composable
fun DialogDeleteAll(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            // Custom title section - full width, no padding
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = AppColors.Pink500,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    )
            ) {
                Text(
                    text = stringResource(Res.string.delete_all),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                )
            }

            // Content section with padding
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(Res.string.delete_all_tasks),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AppButton(
                        text = stringResource(Res.string.cancel),
                        style = AppButtonStyle.Bordered,
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f)
                    )

                    AppButton(
                        text = stringResource(Res.string.delete),
                        style = AppButtonStyle.Filled,
                        onClick = onConfirm,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

