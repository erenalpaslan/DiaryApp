package com.easylife.diary.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.R

/**
 * Created by erenalpaslan on 6.01.2023
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackComposable(
    onDismiss: () -> Unit,
    onSendClicked: (String) -> Unit
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
            Text(text = "Give us feedback")
        },
        text = {
            Column(modifier = Modifier.wrapContentHeight()) {
                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        if (text.length < 250) {
                            text = it
                        }else if (text.length > 250) {
                            text = text.dropLast(1)
                        }
                    },
                    placeholder = {
                        Text(text = "Enter your feedback here!")
                    },
                    modifier = Modifier.height(200.dp).fillMaxWidth()
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text(text = "${text.length}/250")
                }
            }

        },
        confirmButton = {
            Button(onClick = {
                if (text.isNotEmpty()) {
                    onSendClicked(text)
                }
            }) {
                Text(text = "Send")
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_mail),
                contentDescription = "Send Icon",
            )
        },
        dismissButton = {
            Button(onClick = { close() }) {
                Text(text = "Cancel")
            }
        }
    )
}