package com.example.u4_path2_navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.u4_path2_navigation.data.DataSource
import com.example.u4_path2_navigation.data.OrderUiState
import com.example.u4_path2_navigation.ui.OrderSummaryScreen
import com.example.u4_path2_navigation.ui.SelectOptionScreen
import com.example.u4_path2_navigation.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOderUiState = OrderUiState(
        quantity = 6,
        flavor = "Vanilla",
        date = "Wed Jul 21",
        price = "$100",
        pickupOptions = listOf()
    )

    /* When quantity options are provided to StartOrderScreen, the options are displayed on the screen */
    @Test
    fun startOrder_verifyContent(){
        // when StartOrderScreen is loaded
        composeTestRule.setContent {
            StartOrderScreen(
                quantityOptions = DataSource.quantityOptions,
                onNextButtonClicked = {}
            )
        }

        // Then all the options are displayed on the screen
        DataSource.quantityOptions.forEach {
            composeTestRule.onNodeWithStringId(it.first).assertIsDisplayed()
        }
    }



    /**
     * When list of options and subtotal are provided to SelectOptionScreen,the options and subtotal
     * are displayed on the screen and the next button is disabled.
     */
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

    @Test
    fun selectOptionScreen_optionSelected_NextButtonEnabled(){
        // given list of options & subtotal
        val flavours = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent { SelectOptionScreen(subtotal = subtotal, options = flavours) }

        // given list of options
        composeTestRule.onNodeWithText("Vanilla").performClick()

        // Then the next button is disabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }


    /**
     * When a OrderUiState is provided to Summary Screen, then the flavor, date and subtotal is displayed on the screen.
     */
    @Test
    fun summaryScreen_verifyContentDisplay(){
        // when SummaryScreen is loaded
        composeTestRule.setContent {
            OrderSummaryScreen(orderUiState = fakeOderUiState, onCancelButtonClicked = {}, onSendButtonClicked = {_, _ -> })
        }

        // then the UI is updated correctly
        composeTestRule.onNodeWithText(fakeOderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeOderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.subtotal_price, fakeOderUiState.price)).assertIsDisplayed()
    }
}

