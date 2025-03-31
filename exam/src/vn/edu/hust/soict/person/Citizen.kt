package vn.edu.hust.soict.person

data class Citizen(
    override val name: String,
    override val age: Int,
    override val address: String,
    val job: String
) : Person(name, age, address) {

    override fun displayInfo() {
        println(this)
    }
}