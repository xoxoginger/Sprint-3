package ru.sber.oop

interface Fightable {
    var powerType: String
    var healthPoints: Int
    val damageRoll: Int

    fun attack(opponent: Fightable): Int
}


