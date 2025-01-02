package com.example.calmoduletest1

class CalculatorLogic {
    private var currentNumber = ""
    private var previousNumber = ""
    private var currentOperation: String? = null

    fun inputNumber(num: String): String {
        currentNumber += num
        return currentNumber
    }

    fun inputDecimal(): String {
        if (!currentNumber.contains(".")) {
            currentNumber += if (currentNumber.isEmpty()) "0." else "."
        }
        return currentNumber
    }

    fun inputOperation(operation: String): String {
        if (currentNumber.isNotEmpty()) {
            if (previousNumber.isNotEmpty()) {
                calculate()
            }
            previousNumber = currentNumber
            currentNumber = ""
            currentOperation = operation
        }
        return previousNumber
    }

    fun calculate(): String {
        if (previousNumber.isEmpty() || currentNumber.isEmpty() || currentOperation == null) {
            return currentNumber
        }

        val num1 = previousNumber.toDouble()
        val num2 = currentNumber.toDouble()

        val result = when(currentOperation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else Double.POSITIVE_INFINITY
            else -> return currentNumber
        }

        currentNumber = result.toString()
        previousNumber = ""
        currentOperation = null

        return currentNumber
    }

    fun clear(): String {
        currentNumber = ""
        previousNumber = ""
        currentOperation = null
        return ""
    }
}