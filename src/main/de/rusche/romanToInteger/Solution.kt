package de.rusche.romanToInteger

import java.lang.RuntimeException

class Solution {
    companion object {
        const val INVALID_COMBINATION: String = "Invalid combination"
        const val INVALID_CHARACTER: String = "Invalid character"
    }

    var lastValue: Int = -1
    var sameSymbol: Int = 0

    fun romanToInt(s: String): Int {
        var sum = 0
        lastValue = getValueForSymbol(s[0])
        sameSymbol = 0

        for (char: Char in s) {
            sum += processCharAndReturnValue(char)
        }

        return sum
    }

    private fun processCharAndReturnValue(char: Char): Int {
        val valueOfSymbol: Int = getValueForSymbol(char)

        checkForSameSymbolAndThrowException(valueOfSymbol)
        val valueToAdd = calculateValueToAdd(valueOfSymbol)
        lastValue = valueOfSymbol

        return valueToAdd
    }

    private fun checkForSameSymbolAndThrowException(valueOfSymbol: Int) {
        if (lastValue == valueOfSymbol) {
            if (++sameSymbol == 4) {
                throw RuntimeException(INVALID_COMBINATION)
            }
        } else {
            sameSymbol = 0
        }
    }

    private fun calculateValueToAdd(valueOfSymbol: Int): Int {
        return if (lastValue < valueOfSymbol) {
            checkForInvalidSubtraction(valueOfSymbol)

            valueOfSymbol - lastValue * 2
        } else {
            valueOfSymbol
        }
    }

    // I is only allowed before V or X
    // X is only allowed before L or C
    // C is only allowed before D or M
    private fun checkForInvalidSubtraction(valueOfSymbol: Int) {
        if (valueOfSymbol != lastValue * 5 && valueOfSymbol != lastValue * 10) {
            throw RuntimeException(INVALID_COMBINATION)
        }
    }

    private fun getValueForSymbol(char: Char): Int {
        return when (char) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw RuntimeException(INVALID_CHARACTER)
        }
    }
}