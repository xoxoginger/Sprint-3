package ru.sber.oop

interface Fightable {
    val powerType: String
    var healthPoints: Int
    val damageRoll: Int

    fun attack(opponent: Fightable): Int
}

//TODO: create class Player, Monster, Goblin here...


