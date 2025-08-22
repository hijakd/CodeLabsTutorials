package com.example.u4_path2_navigation

import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule

/* ".onNodeWithStringId" is an extension function for 'composeTestRule.onNodeWithText' to shorten the function call
 * from:
 * composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.my_string)
 * to:
 * composeTestRule.onNodeWithStringId(R.string.my_string)
 */

fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.onNodeWithStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithText(activity.getString(id))