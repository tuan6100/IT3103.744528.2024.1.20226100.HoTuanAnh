package com.oop.problem6_3

fun main() {

    print("Input the number of rows to be printed: ")
    val n: Int = readLine()!!.toInt()
    for (i in 1..n) {
        for (j in n downTo i) {
            print(" ")
        }
        for (j in 1..i) {
            print("* ")
        }
        println()
    }
}