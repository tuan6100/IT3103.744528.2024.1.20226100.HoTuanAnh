package vn.edu.hust.soict.management

import vn.edu.hust.soict.person.Citizen
import vn.edu.hust.soict.person.Officer
import vn.edu.hust.soict.person.Person

class DistrictManagement (
    val people: MutableList<Person>
) {

    fun add(person: Person) {
        people.add(person)
    }

    fun displayAll() {
        this.people.forEach { person -> person.displayInfo() }
    }

    fun searchByName(name: String): Person? {
        return people.find { it.name == name }?.let { person ->
            when (person) {
                is Citizen -> person
                is Officer -> person
            }
        }
    }


}