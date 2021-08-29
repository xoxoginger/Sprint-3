package ru.sber.oop

data class User(val name: String, val age: Long) {
    lateinit var city: String
}

fun main() {
    val user1 = User("Alex", 13)
    //TODO: user2 = ...
    //TODO: user3 = ...
}