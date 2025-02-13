package com.oop.problem6_6
import kotlin.system.measureTimeMillis

fun measureTimeMillis(operation: (Matrix, Matrix) -> Matrix, matrix1: Matrix, matrix2: Matrix): Long {
    return measureTimeMillis {
        operation(matrix1, matrix2)
    }
}

fun main() {

    val m1 = Matrix.createRandomMatrix(10000, 10000)
    val m2 = Matrix.createRandomMatrix(10000, 10000)

    val timeAddition = measureTimeMillis(Matrix::plus, m1, m2)
    println("Time taken for matrix addition: $timeAddition ms")

    val timeSubtraction = measureTimeMillis(Matrix::minus, m1, m2)
    println("Time taken for matrix subtraction: $timeSubtraction ms")

//    val m1 = Matrix(listOf(
//        listOf(1.0, 2.0, 3.0),
//        listOf(4.0, 5.0, 6.0),
//        listOf(7.0, 8.0, 9.0)
//    ))
//    val m2 = Matrix(listOf(
//        listOf(9.0, 8.0, 7.0),
//        listOf(6.0, 5.0, 4.0),
//        listOf(3.0, 2.0, 1.0)
//    ))
//    val sum = m1 + m2
//    sum.display()
//    print("\n")
//    val difference = m1 - m2
//    difference.display()





}