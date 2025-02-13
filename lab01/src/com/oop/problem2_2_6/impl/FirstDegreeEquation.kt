package com.oop.problem2_2_6.impl

import com.oop.problem2_2_6.Equation

class FirstDegreeEquation (val a: Double, val b: Double) : Equation {

    override fun display(): String {
        return "Equation: ${a}x + $b = 0"
    }

    override fun solve(): Double {
        if (a == 0.0) {
            if (b == 0.0) {
                return Double.POSITIVE_INFINITY
            }
            throw ArithmeticException("No solution")
        }
        return -b / a
    }

}