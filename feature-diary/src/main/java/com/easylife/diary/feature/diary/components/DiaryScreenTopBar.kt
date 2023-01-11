package com.easylife.diary.feature.diary.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Created by erenalpaslan on 2.01.2023
 */
@Composable
fun DiaryScreenTopBar(
    isEmpty: Boolean = false,
    onSearched: (String) -> Unit
) {
    var isSearching by remember {
        mutableStateOf(false)
    }
    var searchText by remember {
        mutableStateOf("")
    }

    if (isSearching) {
        TopAppBar(
            title = {
                Row() {
                    TextField(
                        value = searchText,
                        onValueChange = {
                            searchText = it
                            onSearched(searchText)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text("Search", style = MaterialTheme.typography.titleLarge)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = MaterialTheme.colorScheme.onBackground,
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                    IconButton(
                        onClick = {
                            searchText = ""
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "clear icon"
                        )
                    }
                }
            },
            navigationIcon = {
                IconButton(onClick = {
                    isSearching = false
                    searchText = ""
                }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = "Back Arrow"
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background),
                actionIconContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background)
            )
        )
    } else {
        TopAppBar(
            title = {
                Text(text = "Diary")
            },
            actions = {
                if (!isEmpty) {
                    IconButton(onClick = {
                        isSearching = true
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background),
                actionIconContentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background)
            )
        )
    }
}