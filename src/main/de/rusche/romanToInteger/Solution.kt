package de.rusche.romanToInteger

import java.lang.RuntimeException

class Solution {
    fun romanToInt(s: String): Int {
        var sum: Int = 0
        var lastValue: Int = getValueForSymbol(s.get(0))
        var sameSymbol: Int = 0

        for (char: Char in s) {
            val value: Int = getValueForSymbol(char)

            if (lastValue == value) {
                if (++sameSymbol == 4) {
                    throw RuntimeException()
                }
            }
            else {
                sameSymbol = 0
            }

            if (lastValue < value) {
                if (lastValue == 1 && value != 5 && value != 10) throw RuntimeException("Invalid combination")
                if (lastValue == 10 && value != 50 && value != 100) throw RuntimeException("Invalid combination")
                if (lastValue == 100 && value != 500 && value != 1000) throw RuntimeException("Invalid combination")

                sum += value - lastValue * 2
            }
            else {
                sum += value
            }

            lastValue = value
        }

        return sum
    }

    private fun getValueForSymbol(char: Char): Int {
        if (char == 'I') return 1
        if (char == 'V') return 5
        if (char == 'X') return 10
        if (char == 'L') return 50
        if (char == 'C') return 100
        if (char == 'D') return 500
        if (char == 'M') return 1000

        throw RuntimeException("Invalid character")
    }
}