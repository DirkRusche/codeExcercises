package de.rusche.romanToInteger

import org.junit.jupiter.api.Assertions
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
        Assertions.assertEquals(3, solution.romanToInt("III"))
    }

    @Test
    fun givenTestCase2() {
        Assertions.assertEquals(4, solution.romanToInt("IV"))
    }

    @Test
    fun givenTestCase3() {
        Assertions.assertEquals(9, solution.romanToInt("IX"))
    }

    @Test
    fun givenTestCase4() {
        Assertions.assertEquals(58, solution.romanToInt("LVIII"))
    }

    @Test
    fun givenTestCase5() {
        Assertions.assertEquals(1994, solution.romanToInt("MCMXCIV"))
    }

    @Test
    fun checkSymbolI() {
        Assertions.assertEquals(1, solution.romanToInt("I"))
    }

    @Test
    fun checkSymbolV() {
        Assertions.assertEquals(5, solution.romanToInt("V"))
    }

    @Test
    fun checkSymbolX() {
        Assertions.assertEquals(10, solution.romanToInt("X"))
    }

    @Test
    fun checkSymbolL() {
        Assertions.assertEquals(50, solution.romanToInt("L"))
    }

    @Test
    fun checkSymbolC() {
        Assertions.assertEquals(100, solution.romanToInt("C"))
    }

    @Test
    fun checkSymbolD() {
        Assertions.assertEquals(500, solution.romanToInt("D"))
    }

    @Test
    fun checkSymbolM() {
        Assertions.assertEquals(1000, solution.romanToInt("M"))
    }

    @Test
    fun checkBiggestNumber() {
        Assertions.assertEquals(3999, solution.romanToInt("MMMCMXCIX"))
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