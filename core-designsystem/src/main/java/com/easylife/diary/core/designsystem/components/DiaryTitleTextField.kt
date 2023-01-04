package com.easylife.diary.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

/**
 * Created by erenalpaslan on 3.01.2023
 */
@Composable
fun DiaryTitleTextField(
    title: MutableState<String>
) {
    TextField(
        value = title.value,
        onValueChange = { newTitle ->
            if (newTitle.length < 64)
                title.value = newTitle
        },
        placeholder = {
            Text(
                "Title",
                style = MaterialTheme.typography.titleLarge
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.onBackground,
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = MaterialTheme.typography.titleLarge
    )
}