package com.example.u3_path1

class Collections {
}

/* using arrayOf() */
// fun main() {
//     val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
//     val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
//     val solarSystem = rockPlanets + gasPlanets
//
//     println(solarSystem[0])
//     println(solarSystem[1])
//     println(solarSystem[2])
//     println(solarSystem[3])
//     println(solarSystem[4])
//     println(solarSystem[5])
//     println(solarSystem[6])
//     println(solarSystem[7])
//
//     solarSystem[3] = "Little Earth"
//
//     println(solarSystem[3])
//
//     // solarSystem[8] = "Pluto" // this throws an IndexOutOfBoundsException
//     val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
//     println(newSolarSystem[8])
// }

/* using listOf() */
// fun main() {
//     val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//
//     println(solarSystem.size)
//
//     println(solarSystem[2])
//     println(solarSystem.get(3))
//
//     println(solarSystem.indexOf("Earth"))
//     println(solarSystem.indexOf("Pluto"))
//
//     println("...")
//
//     for (planet in solarSystem){
//         println(planet)
//     }
// }

// fun main() {
//     val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//
//     solarSystem.add("Pluto")
//     solarSystem.add(3, "Theia")
//     solarSystem[3] = "Future Moon"
//     println(solarSystem[3])
//     println(solarSystem[9])
//
//     solarSystem.removeAt(9)
//     solarSystem.remove("Future Moon")
//
//     println(solarSystem.contains("Pluto"))
//     println("Future Moon" in solarSystem)
// }

/* Sets / MutableSet [mutableSetOf()] */
// fun main() {
//     val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//     println(solarSystem.size)
//
//     solarSystem.add("Pluto")
//     println(solarSystem.size)
//     println(solarSystem.contains("Pluto"))
//     println("Pluto" in solarSystem) // alternatively
//
//     solarSystem.remove("Pluto")
//     println(solarSystem.size)
//     println(solarSystem.contains("Pluto"))
// }

/* Maps */
fun main() {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
                                  )

    println(solarSystem.size)
    solarSystem["Pluto"] = 5  // adding another element to the map

    println(solarSystem.size)
    println(solarSystem["Pluto"])
    println("...")
    println(solarSystem.get("Theia"))
    println(solarSystem["Theia"]) // alternatively

    solarSystem.remove("Pluto")
    println(solarSystem.size)
    solarSystem["Jupiter"] = 78 // updates the value of the "Jupiter" key
    println(solarSystem["Jupiter"])
}