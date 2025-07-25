package com.example.u2_path3

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculatorTests {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun calculateTip_15PercentNoRoundup(){
        val amount = 10.0
        val tipPercent = 15.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(1.5)
        val actualTip = calculateTip(amount = amount, tipPercentage = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_20PercentNoRoundup(){
        val amount = 10.0
        val tipPercent = 20.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercentage = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}