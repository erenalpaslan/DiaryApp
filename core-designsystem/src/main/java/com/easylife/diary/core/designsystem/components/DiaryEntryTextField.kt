package com.easylife.diary.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Created by erenalpaslan on 3.01.2023
 */
@Composable
fun DiaryEntryTextField(
    entry: String?,
    onTextChanged: (String?) -> Unit
) {
    TextField(
        value = entry ?: "",
        onValueChange = { newEntry ->
            onTextChanged(newEntry)
        },
        placeholder = {
            Text("Diary entry")
        },
        modifier = Modifier.fillMaxSize(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.onBackground,
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}