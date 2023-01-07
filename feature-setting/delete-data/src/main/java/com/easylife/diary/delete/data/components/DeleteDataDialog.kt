package com.easylife.diary.delete.data.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.core.designsystem.theme.white

/**
 * Created by erenalpaslan on 6.01.2023
 */
@Composable
fun DeleteDataDialog(
    onDismiss: () -> Unit,
    onDeleteClicked: () -> Unit
) {
    val close: () -> Unit = remember {
        {
            onDismiss()
        }
    }
    AlertDialog(
        onDismissRequest = { close() },
        title = {
            Text(text = "Warning")
        },
        text = {
            Text(text = "All the saved data will be deleted")
        },
        confirmButton = {
            Button(onClick = {
                onDeleteClicked()
            },
            colors = ButtonDefaults.buttonColors(containerColor = red, contentColor = white)
                ) {
                Text(text = "Delete")
            }
        },
        icon = {
            Icon(
                imageVector = Icons.Rounded.Warning,
                contentDescription = "Send Icon",
                tint = red
            )
        },
        dismissButton = {
            OutlinedButton(onClick = { close() }) {
                Text(text = "Cancel")
            }
        }
    )
}
