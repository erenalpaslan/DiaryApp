package com.easylife.diary.feature.diary.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

    if (isSearching) {
        TopAppBar(
            title = {
                Text(text = "Search")
            },
            navigationIcon = {
                IconButton(onClick = {
                    isSearching = false
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
    }else {
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