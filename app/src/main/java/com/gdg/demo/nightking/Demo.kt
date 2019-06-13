package com.gdg.demo.nightking

data class Demo(val time: String, val title: String, val venue: String)

fun dummyData(): List<Demo> = listOf(
    Demo("11:30 PM", "Intro To Dark Theme", "ROOM A"),
    Demo("11:40 PM", "Q And Dark Theme", "ROOM A"),
    Demo("11:50 PM", "Best Practices", "ROOM A"),
    Demo("12:00 PM", "The Night is Dark", "ROOM A")
)