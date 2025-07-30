package com.example.u3_path2

fun main() {
    val enumedEvent = EEvent(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day",
        daypart = Daypart.Evening,
        durationInMinutes = 15
                            )

    println(enumedEvent)
}