@file:JvmName("EquationKt")

package com.oop.problem2_2_6

import com.oop.problem2_2_6.impl.FirstDegreeEquation
import com.oop.problem2_2_6.impl.SecondDegreeEquation
import com.oop.problem2_2_6.impl.SystemOfFirstDegreeEquations

fun main() {
    val firstDegreeEquation = FirstDegreeEquation(2.0, 3.0)
    println(firstDegreeEquation.display())
    println("Solution: ${firstDegreeEquation.solve()}\n")

    val secondDegreeEquation = SecondDegreeEquation(1.0, 2.0, 1.0)
    println(secondDegreeEquation.display())
    println("Solution: ${secondDegreeEquation.solve()}\n")

    val systemOfFirstDegreeEquations = SystemOfFirstDegreeEquations(  1.0, 0.0, 3.0, 1.0, 2.0, 4.0)
    println(systemOfFirstDegreeEquations.display())
    try {
        println("Solution: ${systemOfFirstDegreeEquations.solve()}\n")
    } catch (e: ArithmeticException) {
        println(e.message)
    }
}