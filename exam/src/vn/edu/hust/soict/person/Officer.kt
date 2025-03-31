package vn.edu.hust.soict.person

data class Officer(
    override val name: String,
    override val age: Int,
    override val address: String,
    val job: String
) : Person(name, age, address) {

    override fun displayInfo(){
        print(this)
    }
}
