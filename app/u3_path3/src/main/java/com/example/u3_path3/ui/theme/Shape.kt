package com.example.u3_path3.ui.theme

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

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(50.dp),
    // small = RoundedCornerShape(70.dp),
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp),

                   )

val RoundBottom = Shapes(
    large = RoundedCornerShape(topStart = 7.dp, topEnd = 7.dp, bottomStart = 45.dp, bottomEnd = 45.dp)
                        )