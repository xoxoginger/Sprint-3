package ru.sber.oop

//open, чтобы сделать наследуемым
open class Room(val name: String, val size: Int) {
    //par.4
    constructor(name: String) : this(name, 100)
    //par.2
    protected open val dangerLevel = 5
    fun description() = "Room: $name"
    //par.6
    open fun load() = monster.getSalutation() //"Nothing much to see here..."
    //par.5
    val monster: Monster = Goblin("Knife Thrower", 666, "Sleepwalker", "You'll die in an instant")
}

//par.1
class TownSquare : Room("Town Square", 1000) {
    //par.3
    final override fun load() = "Adventures await us!"
    //par.2
    override val dangerLevel = super.dangerLevel - 3
    
}

fun main() {
    val room1 = Room("Room1")
    println(room1.size)
    val room2 = Room("Room2", 2)
    println(room2.size)
    val TS1 = TownSquare()
    println(TS1.name)
}
