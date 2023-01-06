package com.easylife.diary.delete.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.NavigationButton
import com.easylife.diary.delete.data.components.DeleteDataDialog

/**
 * Created by erenalpaslan on 6.01.2023
 */
class DeleteDataScreen : BaseScreen<DeleteDataViewModel>() {
    @Composable
    override fun Screen() {
        var showDialog by remember {
            mutableStateOf(false)
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Delete app data")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navigator.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBackIosNew,
                                contentDescription = "Back Icon"
                            )
                        }
                    }
                )
            }
        ) {
            Column(modifier = Modifier.padding(it)) {
                NavigationButton(
                    title = "Delete data from phone",
                    description = "You will be able to restore your data from a backup if you have one"
                ) {
                    showDialog = true
                }
            }
        }

        if (showDialog) {
            DeleteDataDialog(onDismiss = {
                showDialog = false
            }) {
                //TODO: Delete preference and open from splash
            }
        }
    }
}