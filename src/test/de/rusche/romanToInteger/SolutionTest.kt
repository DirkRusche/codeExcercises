package de.rusche.romanToInteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SolutionTest {

    private lateinit var solution: Solution

    @BeforeEach
    fun setUp() {
        this.solution = Solution()
    }

    @Test
    fun givenTestCase1() {
        assertEquals(3, solution.romanToInt("III"))
    }

    @Test
    fun givenTestCase2() {
        assertEquals(4, solution.romanToInt("IV"))
    }

    @Test
    fun givenTestCase3() {
        assertEquals(9, solution.romanToInt("IX"))
    }

    @Test
    fun givenTestCase4() {
        assertEquals(58, solution.romanToInt("LVIII"))
    }

    @Test
    fun givenTestCase5() {
        assertEquals(1994, solution.romanToInt("MCMXCIV"))
    }

    @Test
    fun checkSymbolI() {
        assertEquals(1, solution.romanToInt("I"))
    }

    @Test
    fun checkSymbolV() {
        assertEquals(5, solution.romanToInt("V"))
    }

    @Test
    fun checkSymbolX() {
        assertEquals(10, solution.romanToInt("X"))
    }

    @Test
    fun checkSymbolL() {
        assertEquals(50, solution.romanToInt("L"))
    }

    @Test
    fun checkSymbolC() {
        assertEquals(100, solution.romanToInt("C"))
    }

    @Test
    fun checkSymbolD() {
        assertEquals(500, solution.romanToInt("D"))
    }

    @Test
    fun checkSymbolM() {
        assertEquals(1000, solution.romanToInt("M"))
    }

    @Test
    fun checkBiggestNumber() {
        assertEquals(3999, solution.romanToInt("MMMCMXCIX"))
    }

    @Test
    fun checkInvalidNumberBiggerThanAllowed() {
        assertThrows<Throwable> { solution.romanToInt("MMMMMM") }
    }

    @Test
    fun checkInvalidNumber4TimesI() {
        assertThrows<Throwable> { solution.romanToInt("IIII") }
    }

    @Test
    fun checkInvalidCombination49() {
        assertThrows<Throwable> { solution.romanToInt("IL") }
    }

    @Test
    fun checkInvalidCombination99() {
        assertThrows<Throwable> { solution.romanToInt("IC") }
    }

    @Test
    fun checkInvalidCombination999() {
        assertThrows<Throwable> { solution.romanToInt("IM") }
    }

    @Test
    fun checkInvalidCombination490() {
        assertThrows<Throwable> { solution.romanToInt("XD") }
    }

    @Test
    fun checkEmptyString() {
        assertThrows<Throwable> { solution.romanToInt("") }
    }

    @Test
    fun checkSingleWrongSymbol() {
        assertThrows<Throwable> { solution.romanToInt("Y") }
    }
}