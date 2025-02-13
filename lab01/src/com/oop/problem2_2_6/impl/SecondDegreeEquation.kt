package com.oop.problem2_2_6.impl

import com.oop.problem2_2_6.Equation
import kotlin.math.sqrt

class SecondDegreeEquation (val a: Double, val b: Double, val c: Double) : Equation {

    override fun display(): String {
        return "Equation: ${a}x^2 + ${b}x + $c = 0"
    }

    override fun solve(): Pair<Double, Double> {
        if (a == 0.0) {
            return FirstDegreeEquation(b, c).solve() to Double.POSITIVE_INFINITY
        }
        val delta = b * b - 4 * a * c
        if (delta < 0) {
            throw ArithmeticException("No solution")
        }
        val x1 = (-b + sqrt(delta)) / (2 * a)
        val x2 = (-b - sqrt(delta)) / (2 * a)
        return Pair(x1, x2)
    }
}