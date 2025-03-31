package vn.edu.hust.soict

import vn.edu.hust.soict.management.DistrictManagement
import vn.edu.hust.soict.person.Citizen
import vn.edu.hust.soict.person.Officer

fun main() {
    val districtManagement = DistrictManagement(mutableListOf())
    val firstPerson = Citizen("xxx", 20, "xxx", "xxx")
    val secondPerson = Officer("yyy", 20, "yyy", "yyy")
    districtManagement.add(firstPerson)
    districtManagement.add(secondPerson)
    districtManagement.displayAll()
}