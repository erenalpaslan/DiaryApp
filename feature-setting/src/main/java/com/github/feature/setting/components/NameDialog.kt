package com.github.feature.setting.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.easylife.diary.core.designsystem.R

/**
 * Created by erenalpaslan on 6.01.2023
 */
@Composable
fun NameDialog(
    onDismiss: () -> Unit,
    onSaveClicked: (String) -> Unit
) {
    val close: () -> Unit = remember {
        {
            onDismiss()
        }
    }
    var text by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { close() },
        title = {
            Text(text = "Tell us what to call you")
        },
        text = {
            Column(modifier = Modifier.wrapContentHeight()) {
                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        if (text.length < 64) {
                            text = it
                        } else if (text.length > 64) {
                            text = text.dropLast(1)
                        }
                    },
                    placeholder = {
                        Text(text = "Name")
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "User icon"
                        )
                    }
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text(text = "${text.length}/64")
                }
            }

        },
        confirmButton = {
            Button(onClick = {
                onSaveClicked(text)
            }) {
                Text(text = "Save")
            }
        },
        dismissButton = {
            Button(onClick = { close() }) {
                Text(text = "Cancel")
            }
        }

    )
}
