package com.oop.problem2_2_6.impl

import com.oop.problem2_2_6.Equation

class SystemOfFirstDegreeEquations(val a11: Double, val a12: Double, val b1: Double,
                                   val a21: Double, val a22: Double, val b2: Double) : Equation {

    override fun display(): String {
        return """
            |System of equations:
            | ._ ${a11}x + ${a12}y = $b1
            | |_ ${a21}x + ${a22}y = $b2
        """.trimMargin()
    }

    override fun solve(): Pair<Any, Any> {
        val d = a11 * a22 - a12 * a21
        val dx = b1 * a22 - b2 * a12
        val dy = a11 * b2 - a21 * b1
        if (d == 0.0) {
            if (dx == 0.0 && dy == 0.0) {
                if (a12 == 0.0 && a22 == 0.0) {
                    if (a11 == 0.0 && a21 == 0.0) {
                        if (b1 == 0.0 && b2 == 0.0) {
                            return Pair("any", "any")
                        } else {
                            throw ArithmeticException("The system has no solution.")
                        }
                    } else if (a11 != 0.0 ) {
                        val y = b1 / a11
                        if (y  * a21 == b2) {
                            return Pair("any", y)
                        } else {
                            throw ArithmeticException("The system has no solution.")
                        }
                    } else if (a21 != 0.0) {
                        val y = b2 / a21
                        if (y * a11 == b1) {
                            return Pair("any", y)
                        } else {
                            throw ArithmeticException("The system has no solution.")
                        }
                    }
                } else if (a11 == 0.0 && a21 == 0.0) {
                    if (a12 != 0.0) {
                        val x = b1 / a12
                        if (x * a22 == b2) {
                            return Pair(x, "any")
                        } else {
                            throw ArithmeticException("The system has no solution.")
                        }
                    } else if (a22 != 0.0) {
                        val x = b2 / a22
                        if (x * a12 == b1) {
                            return Pair(x, "any")
                        } else {
                            throw ArithmeticException("The system has no solution.")
                        }
                    }
                }
            } else {
                throw ArithmeticException("The system has no solution.")
            }
        }
        val x = dx / d
        val y = dy / d
        return Pair(x, y)
    }

}