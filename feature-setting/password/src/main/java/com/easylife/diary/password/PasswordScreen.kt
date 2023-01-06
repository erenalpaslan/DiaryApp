package com.easylife.diary.password

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
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.SwitchButton

/**
 * Created by erenalpaslan on 6.01.2023
 */
class PasswordScreen : BaseScreen<PasswordViewModel>() {
    @Composable
    override fun Screen() {
        var isFingerprintChecked by remember {
            mutableStateOf(false)
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Password (PIN)")
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
            Column(
                modifier = Modifier.padding(it)
                    .padding(vertical = 24.dp)
            ) {
                SwitchButton(
                    title = "Fingerprint or Face recognition",
                    description = "If the device supports this function",
                    checked = isFingerprintChecked,
                    onCheckedChange = { isChecked ->
                        isFingerprintChecked = isChecked
                    })
            }
        }
    }
}