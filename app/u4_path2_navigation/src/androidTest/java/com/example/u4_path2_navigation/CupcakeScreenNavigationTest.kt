package com.example.u4_path2_navigation


import android.icu.util.Calendar
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.u4_path2_navigation.CupcakeApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Locale


class CupcakeScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupCupcakeNavHost(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }

    @Test
    fun cupcakeNavHost_verifyStartDestination(){
        // assertEquals(CupcakeScreen.Start.name, navController.currentBackStackEntry?. destination?.route)
        // using the extension function
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    /* check for the lack of contentDescription of the back navigation button on the TopAppBar */
    @Test
    fun cupcakeNavHost_verifyBackNavigationNotShownOnStartOrderScreen(){
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    /* using the string resource id to find the "One Cupcake" button, then check the destination name */
    @Test
    fun cupcakeNavHost_clickOneCupcake_navigatesToSelectFlavourScreen(){
        composeTestRule.onNodeWithStringId(R.string.one_cupcake).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Flavour.name)
    }

    @Test
    fun cupcakeNavHost_clickNextOnFlavorScreen_navigatesToPickupScreen(){
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.next).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Pickup.name)
    }

    @Test
    fun cupcakeNavHost_clickNextOnPickupScreen_navigatesToSummaryScreen(){
        navigateToPickupScreen()
        composeTestRule.onNodeWithText(getFormattedDate()).performClick()
        composeTestRule.onNodeWithStringId(R.string.next).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Summary.name)
    }

    @Test
    fun cupcakeNavHost_navigatesToPickupScreen(){
        navigateToPickupScreen()
        navController.assertCurrentRouteName(CupcakeScreen.Pickup.name)
    }

    @Test
    fun cupcakeNavHost_navigatesToSummaryScreen(){
        navigateToSummaryScreen()
        navController.assertCurrentRouteName(CupcakeScreen.Summary.name)
    }

    /* navigate "up" tests */
    @Test
    fun cupcakeNavHost_clickUpOnFlavorScreen_navigatesToStartScreen(){
        navigateToFlavorScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    @Test
    fun cupcakeNavHost_clickUpOnPickupScreen_navigatesToFlavorScreen(){
        navigateToPickupScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(CupcakeScreen.Flavour.name)
    }


    /* "cancel" button tests */
    @Test
    fun cupcakeNavHost_clickCancelOnFlavorScreen_navigatesToStartScreen(){
        navigateToFlavorScreen()
        performCancel()
    }

    @Test
    fun cupcakeNavHost_clickCancelOnPickupScreen_navigatesToStartScreen(){
        navigateToPickupScreen()
        performCancel()
    }

    @Test
    fun cupcakeNavHost_clickCancelOnSummaryScreen_navigatesToStartScreen(){
        navigateToSummaryScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
        // performCancel()
    }




    /* helper functions for navigating through the screens */
    private fun navigateToFlavorScreen(){
        composeTestRule.onNodeWithStringId(R.string.one_cupcake).performClick()
        // "select" a flavour to make the "Next" button enabled in the test
        composeTestRule.onNodeWithStringId(R.string.chocolate).performClick()
    }

    private fun navigateToPickupScreen(){
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.next).performClick()
    }

    private fun navigateToSummaryScreen(){
        navigateToPickupScreen()
        composeTestRule.onNodeWithText(getFormattedDate()).performClick()
        composeTestRule.onNodeWithStringId(R.string.next).performClick()
    }

    /* helper function to test back navigation with the TopAppBar nav button */
    private fun performNavigateUp(){
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }

    private fun performCancel(){
        composeTestRule.onNodeWithStringId(R.string.cancel).performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    /* helper function to generate a formatted date string */
    fun getFormattedDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(java.util.Calendar.DATE, 1)
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        return formatter.format(calendar.time)
    }

}