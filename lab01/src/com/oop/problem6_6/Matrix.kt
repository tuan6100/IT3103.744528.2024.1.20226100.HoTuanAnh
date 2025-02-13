package com.oop.problem6_6

import java.util.stream.IntStream
import kotlin.random.Random

class Matrix(val rows: Int, val cols: Int) {

    val matrix = List(rows) { MutableList(cols) { 0.0 } }


    constructor(data: List<List<Double>>) : this(data.size, data[0].size) {
        for (i in data.indices) {
            for (j in data[i].indices) {
                matrix[i][j] = data[i][j]
            }
        }
    }

    companion object {
        fun createRandomMatrix(rows: Int, cols: Int): Matrix {
            val matrix = Matrix(rows, cols)
            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    matrix.matrix[i][j] = Random.nextDouble()
                }
            }
            return matrix
        }
    }

    fun input() {
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                print("Enter element at position ($i, $j): ")
                matrix[i][j] = readLine()!!.toDouble()
            }
        }
    }

    fun display() {
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

    operator fun plus(otherMatrix: Matrix): Matrix {
        if (rows != otherMatrix.rows || cols != otherMatrix.cols) {
            throw IllegalArgumentException("Both matrices must have the same dimensions")
        }
        val result = Matrix(rows, cols)
        IntStream.range(0, rows * cols).parallel().forEach { i ->
           result.matrix[i / cols][i % cols] = matrix[i / cols][i % cols] + otherMatrix.matrix[i / cols][i % cols]
        }
        return result
    }

    operator fun minus(otherMatrix: Matrix): Matrix {
        if (rows != otherMatrix.rows || cols != otherMatrix.cols) {
            throw IllegalArgumentException("Both matrices must have the same dimensions")
        }
        val result = Matrix(rows, cols)
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                result.matrix[i][j] = matrix[i][j] - otherMatrix.matrix[i][j]
            }
        }
        return result
    }

    operator fun times(scalar: Double): Matrix {
        val result = Matrix(rows, cols)
        IntStream.range(0, rows).parallel().forEach { i ->
            for (j in 0 until cols) {
                result.matrix[i][j] = matrix[i][j] * scalar
            }
        }

        return result
    }

    operator fun times(matrix2: Matrix): Matrix {
        if (cols != matrix2.rows) {
            throw IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix")
        }
        val result = Matrix(rows, matrix2.cols)
        for (i in 0 until rows) {
            for (j in 0 until matrix2.cols) {
                for (k in 0 until cols) {
                    result.matrix[i][j] = result.matrix[i][j].toDouble() + matrix[i][k].toDouble() * matrix2.matrix[k][j].toDouble()
                }
            }
        }
        return result
    }
}