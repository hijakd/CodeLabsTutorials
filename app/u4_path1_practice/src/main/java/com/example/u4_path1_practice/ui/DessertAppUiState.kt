package com.example.u4_path1_practice.ui

import androidx.annotation.DrawableRes
import com.example.u4_path1_practice.data.Datasource.dessertList

// data class DessertAppUiState(
//     val revenue: Int = 0,
//     val dessertsSold: Int = 0,
//     val currentDessertIndex: Int = 0,
//     val currentDessertPrice: Int = 0,
//     val currentDessertImageId: Int = 0
// )

/* solution version */
data class DessertAppUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)