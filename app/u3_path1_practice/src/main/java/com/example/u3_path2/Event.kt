package com.example.u3_path2

import kotlin.compareTo

data class Event(val title: String, val description: String? = null, val daypart: String, val durationInMinutes: Int)

data class EEvent(val title: String, val description: String? = null, val daypart: Daypart, val durationInMinutes: Int)