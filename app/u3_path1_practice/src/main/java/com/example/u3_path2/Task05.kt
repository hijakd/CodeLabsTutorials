package com.example.u3_path2

fun main() {
    val event1 = EEvent(title = "Wake up", description = "Time to get up", daypart = Daypart.Morning, durationInMinutes = 0)
    val event2 = EEvent(title = "Eat breakfast", daypart = Daypart.Morning, durationInMinutes = 15)
    val event3 = EEvent(title = "Learn about Kotlin", daypart = Daypart.Afternoon, durationInMinutes = 30)
    val event4 = EEvent(title = "Practice Compose", daypart = Daypart.Afternoon, durationInMinutes = 60)
    val event5 = EEvent(title = "Watch latest DevBytes video", daypart = Daypart.Afternoon, durationInMinutes = 10)
    val event6 = EEvent(title = "Check out latest Android Jetpack library", daypart = Daypart.Evening, durationInMinutes = 45)

    /* solution version */
    val events = mutableListOf(event1, event2, event3, event4, event5, event6)

    val groupedByDaypart = events.groupBy { it.daypart }
    val morningEvents = events.filter { it.daypart == Daypart.Morning }
    val afternoonEvents = events.filter { it.daypart == Daypart.Afternoon }
    val eveningEvents = events.filter { it.daypart == Daypart.Evening }

    // println("Morning: ${morningEvents.size} events")
    // println("Afternoon: ${afternoonEvents.size} events")
    // println("Evening: ${eveningEvents.size} events")

    /* solution version */
    groupedByDaypart.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
}