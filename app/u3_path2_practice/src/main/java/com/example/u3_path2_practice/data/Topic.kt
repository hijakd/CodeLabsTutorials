package com.example.u3_path2_practice.data

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val name: Int, val associatedCourseCount: Int, @DrawableRes val image: Int)