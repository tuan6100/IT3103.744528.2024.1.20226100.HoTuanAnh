package vn.edu.hust.soict.person

sealed class Person (open val name: String, open val age: Int, open val address: String) {

    abstract fun displayInfo()
}