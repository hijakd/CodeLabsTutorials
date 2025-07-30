package com.example.u3_path1

class Cookie(val name: String, val softBaked: Boolean, val hasFilling: Boolean, val price: Double)

val cookies = listOf(
    Cookie(name = "Chocolate Chip", softBaked = false, hasFilling = false, price = 1.69),
    Cookie(name = "Banana Walnut", softBaked = true, hasFilling = false, price = 1.49),
    Cookie(name = "Vanilla Creme", softBaked = false, hasFilling = true, price = 1.59),
    Cookie(name = "Chocolate Peanut Butter", softBaked = false, hasFilling = true, price = 1.49),
    Cookie(name = "Snickerdoodle", softBaked = true, hasFilling = false, price = 1.39),
    Cookie(name = "Blueberry Tart", softBaked = true, hasFilling = true, price = 1.79),
    Cookie(name = "Sugar and Sprinkles", softBaked = false, hasFilling = false, price = 1.39),
                    )

/* using forEach() - [forEach(action: (T) -> Unit)] */
// fun main() {
//     // cookies.forEach { println("Menu item: $it") }
//     cookies.forEach { println("Menu item: ${it.name}") }
// }

/* using map() */
// fun main() {
//     val fullMenu = cookies.map { "${it.name} - $${it.price}" }
//
//     println("Full menu:")
//     fullMenu.forEach { println(it) }
// }

/* using filter() */
// fun main() {
//     val fullMenu = cookies.map { "${it.name} - $${it.price}" }
//     val softBakedMenu = cookies.filter { it.softBaked }
//
//     println("Full menu:")
//     fullMenu.forEach { println(it) }
//
//     println("...")
//
//     println("Soft cookies:")
//     softBakedMenu.forEach { println("${it.name} - $${it.price}") }
// }

/* using groupBy() */
// fun main() {
//     val fullMenu = cookies.map { "${it.name} - $${it.price}" }
//     val groupedMenu = cookies.groupBy { it.softBaked } // returns a [Map<Boolean, List<Cookie>>]
//     // val softBakedMenu = groupedMenu[true] ?: listOf()
//     val softBakedMenu = groupedMenu[true] ?: emptyList() // alternatively
//     // val crunchyMenu = groupedMenu[false] ?: listOf()
//     val crunchyMenu = groupedMenu[false] ?: emptyList() // alternatively
//
//     println("Full menu:")
//     fullMenu.forEach { println(it) }
//
//     println("...")
//     println("Soft cookies:")
//     softBakedMenu.forEach { println("${it.name} - $${it.price}") }
//
//     println("...")
//     println("Crunchy cookies:")
//     crunchyMenu.forEach { println("${it.name} - $${it.price}") }
// }

/* using fold() */
// fun main() {
//     val fullMenu = cookies.map { "${it.name} - $${it.price}" }
//     val groupedMenu = cookies.groupBy { it.softBaked } // returns a [Map<Boolean, List<Cookie>>]
//     val softBakedMenu = groupedMenu[true] ?: emptyList()
//     val crunchyMenu = groupedMenu[false] ?: emptyList()
//     val totalPrice = cookies.fold(0.0) { total, cookie ->
//         total + cookie.price
//     }
//
//     println("Full menu:")
//     fullMenu.forEach { println(it) }
//
//     println("...")
//     println("Total price: $$totalPrice")
// }

/* using sortedBy() */
fun main() {
    val fullMenu = cookies.map { "${it.name} - $${it.price}" }
    val alphabeticalMenu = cookies.sortedBy { it.name }

    println("Full menu:")
    fullMenu.forEach { println(it) }

    println("...")
    println("Alphabetical menu:")
    alphabeticalMenu.forEach { println(it.name) }
}