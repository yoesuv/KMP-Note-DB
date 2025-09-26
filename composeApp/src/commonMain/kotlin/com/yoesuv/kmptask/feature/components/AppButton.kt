package com.yoesuv.kmptask.feature.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yoesuv.kmptask.core.theme.AppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class AppButtonStyle {
    Filled,
    Bordered
}

@Composable
fun AppButton(
    text: String,
    style: AppButtonStyle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (style) {
        AppButtonStyle.Filled -> {
            Button(
                modifier = modifier,
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.Pink500,
                    contentColor = Color.White
                )
            ) {
                Text(text = text)
            }
        }

        AppButtonStyle.Bordered -> {
            OutlinedButton(
                modifier = modifier,
                onClick = onClick,
                border = BorderStroke(1.dp, AppColors.Pink500),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = AppColors.Pink500
                )
            ) {
                Text(text = text)
            }
        }
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    Column {
        AppButton("Filled Button", AppButtonStyle.Filled, onClick = {})
        AppButton("Bordered Button", AppButtonStyle.Bordered, onClick = {})
    }
}
