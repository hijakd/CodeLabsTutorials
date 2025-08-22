package com.example.u4_path2_navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.u4_path2_navigation.ui.SelectOptionScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun selectOptionScreen_verifyContent(){
        // given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // and subtotal
        val subtotal = "$100"

        // when SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(
                subtotal = subtotal,
                options = flavors,
            )
        }

        // then all the options are displayed on the screen
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        // and then the subtotal is displayed correctly
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.subtotal_price, subtotal)).assertIsDisplayed()

        // and then the next button is disabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }


}