package com.yoesuv.kmptask.feature.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.yoesuv.kmptask.core.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    canBack: Boolean = true,
    navigateUp: () -> Unit = {},
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: () -> Unit = {}
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppColors.Pink500,
            titleContentColor = Color.White
        ),
        title = {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        },
        navigationIcon = {
            if (canBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            if (trailingIcon != null) {
                IconButton(onClick = onTrailingIconClick) {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = "action",
                        tint = Color.White
                    )
                }
            }
        }
    )
}