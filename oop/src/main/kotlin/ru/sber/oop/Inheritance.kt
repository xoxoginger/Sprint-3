package ru.sber.oop

class Room(val name: String, val size: Int) {

    val dangerLevel = 5

    fun description() = "Room: $name"

    fun load() = "Nothing much to see here..."

}
