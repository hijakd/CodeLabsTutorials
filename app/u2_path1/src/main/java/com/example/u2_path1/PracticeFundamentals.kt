package com.example.u2_path1

// Mobile notifications
/*
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100){
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
*/

// Movie ticket price
/*
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is $${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is $${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $adult is $${ticketPrice(adult, false)}.")
    println("The movie ticket price for a person aged $senior is $${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when (age){
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}
*/

// temperature conversion
/*
fun main() {
    val celsius = 27.0
    val fahrenheit = 10.0
    val kelvin = 350.0

//    printFinalTemperature(celsius, "Celsius", "Fahrenheit") { (celsius * 9.0 / 5.0) + 32 }
    printFinalTemperature(celsius, "Celsius", "Fahrenheit") { (it * 9.0 / 5.0) + 32 }
//    printFinalTemperature(kelvin, "Kelvin", "Fahrenheit") { kelvin - 273.15 }
    printFinalTemperature(kelvin, "Kelvin", "Fahrenheit") { it - 273.15 }
//    printFinalTemperature(fahrenheit, "Fahrenheit", "Kelvin") { ((fahrenheit - 32) * 5.0 / 9.0) + 273.15 }
    printFinalTemperature(fahrenheit, "Fahrenheit", "Kelvin") { ((it - 32) * 5.0 / 9.0) + 273.15 }
}

fun printFinalTemperature(
        initialMeasurement: Double,
        initialUnit: String,
        finalUnit: String,
        conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
*/

// Song catalogue
class SongCatalog(val title: String, val artist: String, val yearPublished: Int, var playCount: Int) {

//    var isPopular = playCount > 999
    val isPopular: Boolean
        get() = playCount > 999

    fun printSongInfo() {
        println("$title, performed by $artist, was released in $yearPublished")
    }
}

/*fun main(){
    val blister = SongCatalog("blister in the sun", "violent femmes", 1996, 0)
    blister.playCount++
    blister.printSongInfo()
    println("${blister.title} is popular: ${blister.isPopular}")
    println("${blister.title} play count is: ${blister.playCount}")
}*/

// Internet profile
/*fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}*/

/*
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name\nAge: $age")
        if (referrer != null) {
            println("Likes to $hobby. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.")
        } else {
            println("Likes to $hobby. Doesn't have a referrer.\n")
        }
    }
}
*/

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        val outputHobby = if (hobby != null) {
            "Likes to $hobby."
        } else {
            ""
        }
        val outputReferrer = if (referrer != null) {
            "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
        } else {
            "Likes to $hobby. Doesn't have a referrer.\n"
        }

        println("Name: $name\nAge: $age")
        println("$outputHobby $outputReferrer")
    }
}

// Foldable phones
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true): Phone(){
    override fun switchOn() {
        if (!isFolded){
            super.switchOn()
        }
    }

    fun unfoldPhone(){
        isFolded = false
        switchOn()
    }

    fun foldPhone(){
        isFolded = true
        switchOff()
    }

}

/*
fun main() {
    val foldablePhone = FoldablePhone()

    print("folded\n")
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
    print("\nunfolded\n")
    foldablePhone.unfoldPhone()
    foldablePhone.checkPhoneScreenLight()
    print("\nfolded\n")
    foldablePhone.foldPhone()
    foldablePhone.checkPhoneScreenLight()
}
*/

// Special auction
fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}