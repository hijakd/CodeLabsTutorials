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
package com.gdd.u4_path2_nav_practice_lunch_tray

// import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gdd.u4_path2_nav_practice_lunch_tray.datasource.DataSource
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.AccompanimentMenuScreen
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.CheckoutScreen
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.EntreeMenuScreen
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.OrderViewModel
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.SideDishMenuScreen
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.StartOrderScreen
import com.gdd.u4_path2_nav_practice_lunch_tray.ui.TopBar


enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Entree(title = R.string.choose_entree),
    SideDish(title = R.string.choose_side_dish),
    Accompaniment(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}

// TODO: AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(backStackEntry?.destination?.route ?: LunchTrayScreen.Start.name)

    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        },
        /* modifier = Modifier.fillMaxSize() */
    ) { innerPadding ->
        // Surface(modifier = Modifier.padding(innerPadding)) {
            val uiState by viewModel.uiState.collectAsState()
            NavHost(
                navController = navController,
                startDestination = LunchTrayScreen.Start.name,modifier = Modifier.padding(innerPadding)
            ){
                composable(route = LunchTrayScreen.Start.name) {
                    StartOrderScreen(
                        onStartOrderButtonClicked = { navController.navigate(LunchTrayScreen.Entree.name) },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                composable(route = LunchTrayScreen.Entree.name) {
                    EntreeMenuScreen(
                        options = DataSource.entreeMenuItems,
                        onCancelButtonClicked = {cancelOrderReturnToStart(viewModel, navController)},
                        onNextButtonClicked = { navController.navigate(LunchTrayScreen.SideDish.name) },
                        onSelectionChanged = { viewModel.updateEntree(it) },
                        modifier = Modifier.fillMaxHeight()
                    )
                }
                composable(route = LunchTrayScreen.SideDish.name) {
                    SideDishMenuScreen(
                        options = DataSource.sideDishMenuItems,
                        onCancelButtonClicked = {cancelOrderReturnToStart(viewModel, navController)},
                        onNextButtonClicked = { navController.navigate(LunchTrayScreen.Accompaniment.name) },
                        onSelectionChanged = { viewModel.updateSideDish(it) },
                        modifier = Modifier.fillMaxHeight()
                    )
                }
                composable(route = LunchTrayScreen.Accompaniment.name) {
                    AccompanimentMenuScreen(
                        options = DataSource.accompanimentMenuItems,
                        onCancelButtonClicked = {cancelOrderReturnToStart(viewModel, navController)},
                        onNextButtonClicked = { navController.navigate(LunchTrayScreen.Checkout.name) },
                        onSelectionChanged = { viewModel.updateAccompaniment(it) },
                        modifier = Modifier.fillMaxHeight()
                    )
                }
                composable(route = LunchTrayScreen.Checkout.name) {
                    CheckoutScreen(
                        orderUiState = uiState,
                        onNextButtonClicked = { cancelOrderReturnToStart(viewModel, navController) },
                        onCancelButtonClicked = { cancelOrderReturnToStart(viewModel, navController) },
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            }
        // }
    }
}

private fun cancelOrderReturnToStart(viewModel: OrderViewModel, navController: NavHostController){
    viewModel.resetOrder()
    navController.popBackStack(route = LunchTrayScreen.Start.name, inclusive = false)
}