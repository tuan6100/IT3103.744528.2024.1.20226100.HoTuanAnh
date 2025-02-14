package com.oop.problem2_2_6.test

import com.oop.problem2_2_6.impl.SystemOfFirstDegreeEquations
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SystemOfFirstDegreeEquationsTest {

    @Test
    fun testUniqueSolution() {
        val system = SystemOfFirstDegreeEquations(  1.0, 2.0, 3.0,
                                                    4.0, 5.0, 6.0)
        val solution = system.solve()
        assertEquals(Pair(-1.0, 2.0), solution)
    }

    @Test
    fun testInfiniteSolutions() {
        val system = SystemOfFirstDegreeEquations(  1.0, 2.0, 3.0,
                                                    2.0, 4.0, 6.0)
        val solution = system.solve()
        assertEquals(Pair("any", "any"), solution)
    }

    @Test
    fun testNoSolution() {
        val system = SystemOfFirstDegreeEquations(  1.0, 2.0, 3.0,
                                                    1.0, 2.0, 4.0)
        val exception = assertThrows(ArithmeticException::class.java) {
            system.solve()
        }
        assertEquals("The system has no solution.", exception.message)
    }

    @Test
    fun testInfiniteSolutionsWithSpecificY() {
        val system = SystemOfFirstDegreeEquations(  0.0, 2.0, 4.0,
                                                    0.0, 4.0, 8.0)
        val solution = system.solve()
        assertEquals(Pair("any", 2.0), solution)
    }

    @Test
    fun testInfiniteSolutionsWithSpecificX() {
        val system = SystemOfFirstDegreeEquations(  2.0, 0.0, 4.0,
                                                    4.0, 0.0, 8.0)
        val solution = system.solve()
        assertEquals(Pair(2.0, "any"), solution)
    }
}