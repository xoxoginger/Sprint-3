package ru.sber.oop

import kotlin.random.Random

interface Fightable {
    val powerType: String
    var healthPoints: Int
    val damageRoll: Int get() = Random.nextInt(1, 100) //par.1

    fun attack(opponent: Fightable): Int
}

//par.2
class Player(override val powerType: String,
            override var healthPoints: Int,
            val name: String,
            var isBlessed: Boolean) : Fightable {
    override fun attack(opponent: Fightable): Int {
        var damage = damageRoll
        if (isBlessed) damage *= 2 
        opponent.healthPoints -= damage
        return damage
    }
}

//par.3
abstract class Monster(override val powerType : String,
                    override var healthPoints : Int,
                    open val name : String,
                    open val description : String) : Fightable {
    override fun attack(opponent: Fightable): Int {
        var damage = damageRoll
        opponent.healthPoints -= damage
        return damage
    }
    //par.6
    fun getSalutation() = "Ho ho ho! I'm gonna kill you..."
}

//par.4
class Goblin(override val powerType: String, 
            override var healthPoints: Int,
            override val name: String,
            override val description: String) : Monster(powerType,
                                                        healthPoints,
                                                        name,
                                                        description) {
    override val damageRoll: Int get() = super.damageRoll / 2 
}


//fun main() {
    //val pl = Player("sgfg", 100, "Player1", false)
    //val pl2 = Player("asdasd", 200, "Player2", false)
    //println(pl.attack(pl2))
//}

