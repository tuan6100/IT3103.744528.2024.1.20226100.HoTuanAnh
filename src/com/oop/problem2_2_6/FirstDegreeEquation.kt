package com.oop.problem2_2_6

class FirstDegreeEquation (val a: Double, val b: Double) {

    fun display(): String {
        return "Equation: ${a}x + $b = 0"
    }

    fun solve(): Double {
        if (a == 0.0) {
            if (b == 0.0) {
                return Double.POSITIVE_INFINITY
            }
            throw ArithmeticException("No solution")
        }
        return -b / a
    }

}