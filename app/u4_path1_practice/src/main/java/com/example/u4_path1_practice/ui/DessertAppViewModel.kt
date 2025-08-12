package com.example.u4_path1_practice.ui

import androidx.lifecycle.ViewModel
import com.example.u4_path1_practice.data.Datasource.dessertList
import kotlinx.coroutines.flow.*

class DessertAppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DessertAppUiState())
    val uiState: StateFlow<DessertAppUiState> = _uiState.asStateFlow()

    private var currentPrice = 0
    private var currentImageId = 0


    // fun setCurrentPrice(dessertPrice: Int){
    //     currentPrice = dessertPrice
    // }
    //
    // fun setCurrentImageId(imageId: Int){
    //     currentImageId = imageId
    // }
    //
    // fun updateRevenue(currentDessertPrice: Int){
    //     currentPrice += currentDessertPrice
    //     _uiState.update { currentState ->
    //         currentState.copy(revenue = currentPrice)
    //     }
    // }
    //
    // fun updateUiState(/* currentDessertPrice: Int */){
    //     // _uiState.value = price
    //     val increasedSold = _uiState.value.dessertsSold + 1
    //     val revenue = _uiState.value.revenue + currentPrice
    //     _uiState.update { currentState ->
    //         currentState.copy(revenue = revenue, dessertsSold = increasedSold, currentDessertImageId = currentImageId)
    //     }
    // }

    /* solution version */
    fun onDessertClicked() {
        _uiState.update { currentState ->
            val dessertsSold = currentState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            currentState.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = currentState.revenue + currentState.currentDessertPrice,
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more
                // desserts, you'll start producing more expensive desserts as determined by
                // startProductionAmount. We know to break as soon as we see a dessert who's
                // "startProductionAmount" is greater than the amount sold.
                break
            }
        }
        return dessertIndex
    }
}