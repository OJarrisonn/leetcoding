package com.harrisonn.`2024`.`12`

class AtoiSolution {
    fun myAtoi(s: String): Int {
        var result = 0
        var sign = 1
        var arg = s.trimStart()
        if (arg.startsWith('-')) {
            sign = -1
            arg = arg.substring(1)
        } else if (arg.startsWith('+')) arg = arg.substring(1)
        arg = arg.trimStart('0')

        for (c in arg) {
            if (!c.isDigit()) break
            if (result > Int.MAX_VALUE / 10 || result == Int.MAX_VALUE / 10 && c > '7') return Int.MAX_VALUE
            if (result < Int.MIN_VALUE / 10 || result == Int.MIN_VALUE / 10 && c > '8') return Int.MIN_VALUE
            result *= 10
            result += sign * c.digitToInt()
        }

        return result
    }
}