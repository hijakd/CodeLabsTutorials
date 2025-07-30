package com.example.u3_path2

fun main() {
    val event1 = EEvent(title = "Wake up", description = "Time to get up", daypart = Daypart.Morning, durationInMinutes = 0)
    val event2 = EEvent(title = "Eat breakfast", daypart = Daypart.Morning, durationInMinutes = 15)
    val event3 = EEvent(title = "Learn about Kotlin", daypart = Daypart.Afternoon, durationInMinutes = 30)
    val event4 = EEvent(title = "Practice Compose", daypart = Daypart.Afternoon, durationInMinutes = 60)
    val event5 = EEvent(title = "Watch latest DevBytes video", daypart = Daypart.Afternoon, durationInMinutes = 10)
    val event6 = EEvent(title = "Check out latest Android Jetpack library", daypart = Daypart.Evening, durationInMinutes = 45)

    /* my version */
    val eventList = mutableListOf(
        EEvent(title = "Wake up", description = "Time to get up", daypart = Daypart.Morning, durationInMinutes = 0),
        EEvent(title = "Eat breakfast", daypart = Daypart.Morning, durationInMinutes = 15),
        EEvent(title = "Learn about Kotlin", daypart = Daypart.Afternoon, durationInMinutes = 30),
        EEvent(title = "Practice Compose", daypart = Daypart.Afternoon, durationInMinutes = 60),
        EEvent(title = "Watch latest DevBytes video", daypart = Daypart.Afternoon, durationInMinutes = 10),
        EEvent(title = "Check out latest Android Jetpack library", daypart = Daypart.Evening, durationInMinutes = 45)
                                 )

    /* solution version */
    val events = mutableListOf<EEvent>(event1, event2, event3, event4, event5, event6)
}