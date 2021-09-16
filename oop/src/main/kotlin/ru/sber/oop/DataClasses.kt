package ru.sber.oop

data class User(val name: String, val age: Long) {
    lateinit var city: String
    //par.2
    override fun equals(other: Any?): Boolean {
        if (other is User) 
            return (this.name == other.name &&
                    this.age == other.age &&
                    this.city == other.city)
                    
        else return false
        }
}

fun main() {
    val user1 = User("Alex", 13)
    //par.1
    val user2 = user1.copy(name = "Juli")
    //par.2
    user1.city = "Omsk"
    val user3 = user1.copy()
    user3.city = "Tomsk"
    
    println(user3.city)
    println(user1.equals(user3))
}
