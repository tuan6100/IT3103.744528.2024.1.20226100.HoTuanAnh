package com.oop.problem2_2_5

import javax.swing.JOptionPane
import kotlin.system.exitProcess

fun add(a: Double, b: Double): Double {
    return a + b
}

fun sub(a: Double, b: Double): Double {
    return a - b
}

fun mul(a: Double, b: Double): Double {
    return a * b
}

fun div(a: Double, b: Double): Double {
    if (b == 0.0) {
        throw ArithmeticException("Division by zero is not allowed.")
    }
    return a / b
}

fun main() {
    val strNum1: String = JOptionPane.showInputDialog(
        null, "Please input the first number: ",
        "Input the first number", JOptionPane.INFORMATION_MESSAGE
    )
    val strNum2: String = JOptionPane.showInputDialog(
        null, "Please input the second number: ",
        "Input the second number", JOptionPane.INFORMATION_MESSAGE
    )
    var strNotification: String? = "You've just entered"
    strNotification += " $strNum1 and $strNum2"
    JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE)

    val num1 = strNum1.toDouble()
    val num2 = strNum2.toDouble()
    JOptionPane.showMessageDialog(
        null, "Sum: " + add(num1, num2),
        "Addition", JOptionPane.INFORMATION_MESSAGE
    )

    JOptionPane.showMessageDialog(
        null, "Subtraction: " + sub(num1, num2),
        "Subtraction", JOptionPane.INFORMATION_MESSAGE
    )

    JOptionPane.showMessageDialog(
        null, "Multiplication: " + mul(num1, num2),
        "Multiplication", JOptionPane.INFORMATION_MESSAGE
    )

    try {
        JOptionPane.showMessageDialog(
            null, "Division: " + div(num1, num2),
            "Division", JOptionPane.INFORMATION_MESSAGE
        )
    } catch (e: ArithmeticException) {
        JOptionPane.showMessageDialog(null, e.message, "Error", JOptionPane.ERROR_MESSAGE)
    }

    exitProcess(0)
}