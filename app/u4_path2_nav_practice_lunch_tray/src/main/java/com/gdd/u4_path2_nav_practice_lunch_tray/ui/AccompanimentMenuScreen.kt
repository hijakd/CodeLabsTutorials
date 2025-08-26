/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gdd.u4_path2_nav_practice_lunch_tray.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gdd.u4_path2_nav_practice_lunch_tray.datasource.DataSource
import com.gdd.u4_path2_nav_practice_lunch_tray.model.MenuItem
import com.gdd.u4_path2_nav_practice_lunch_tray.model.MenuItem.AccompanimentItem

@Composable
fun AccompanimentMenuScreen(
    options: List<AccompanimentItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (AccompanimentItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(options = options, onCancelButtonClicked = onCancelButtonClicked,
                   onNextButtonClicked = onNextButtonClicked,
                   onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
                   modifier = modifier)
}

@Preview
@Composable
private fun AccompanimentItemPreview() {
    AccompanimentMenuScreen(
        options = DataSource.accompanimentMenuItems,
        onCancelButtonClicked = { TODO() },
        onNextButtonClicked = { TODO() },
        onSelectionChanged = { TODO() },
    )
}