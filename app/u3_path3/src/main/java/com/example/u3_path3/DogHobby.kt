package com.example.u3_path3

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun DogHobby(@StringRes dogHobby: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(stringResource(R.string.about), style = MaterialTheme.typography.labelSmall)
        Text(stringResource(dogHobby), style = MaterialTheme.typography.bodyLarge)
    }
}