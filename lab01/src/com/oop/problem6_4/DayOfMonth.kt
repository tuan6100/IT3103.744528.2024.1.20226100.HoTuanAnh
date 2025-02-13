package com.oop.problem6_4

import java.util.Calendar

val monthsList = listOf<List<String?>?>(
    listOf<String?>("January", "Jan.", "Jan", "1"),
    listOf<String?>("February", "Feb.", "Feb", "2"),
    listOf<String?>("March", "Mar.", "Mar", "3"),
    listOf<String?>("April", "Apr.", "Apr", "4"),
    listOf<String?>("May", "May.", "May", "5"),
    listOf<String?>("June", "Jun.", "Jun", "6"),
    listOf<String?>("July", "Jul.", "Jul", "7"),
    listOf<String?>("August", "Aug.", "Aug", "8"),
    listOf<String?>("September", "sept.", "sept", "9"),
    listOf<String?>("October", "Oct.", "Oct", "10"),
    listOf<String?>("November", "Nov.", "Nov", "11"),
    listOf<String?>("December", "Dec.", "Dec", "12")
)

fun inputYear(): Int {
    print("Enter year: ")
    val year = readLine()!!.toInt()
    if (year < 0) {
        println("Invalid year. Enter year again: ")
        return inputYear()
    }
    return year
}

fun inputMonth(): Pair<String, Int> {
    print("Enter month: ")
    val month = readLine()!!
    val monthIndex = monthsList.indexOfFirst { it?.contains(month) == true }
    if (monthIndex == -1) {
        println("Invalid month. Enter month again: ")
        return inputMonth()
    }
    return Pair(month, monthIndex)
}

fun inputDay(daysInMonth: Int): Int {
    print("Enter day: ")
    val day = readLine()!!.toInt()
    if (day < 1 || day > daysInMonth) {
        println("Invalid day. Enter day again: ")
        return inputDay(daysInMonth)
    }
    return day
}

fun main() {
    val calendar = Calendar.getInstance()
    val year = inputYear()
    val (month, monthIndex) = inputMonth()
    calendar.set(year, monthIndex, 1)
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    println("Number of days in ${monthsList[monthIndex]?.get(0)} $year: $daysInMonth")
    val day = inputDay(daysInMonth)
    calendar.set(year, monthIndex, day)
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    println("Day of week: ${when (dayOfWeek) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Invalid"
    }}")
}