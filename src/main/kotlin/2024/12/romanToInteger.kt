package com.harrisonn.`2024`.`12`

class RomanToIntSolution {
    fun romanToInt(s: String): Int {
        var prev = 0
        var value = 0

        for (c in s.reversed()) {
            val curr = when (c) {
                'M' -> 1000
                'D' -> 500
                'C' -> 100
                'L' -> 50
                'X' -> 10
                'V' -> 5
                'I' -> 1
                else -> 0
            }
            if (prev > curr) value -= curr
            else value += curr

            prev = curr
        }

        return value
    }
}