package com.harrisonn.`2024`.`12`

import kotlin.math.abs

class RevIntSolution {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE) return 0

        val sign = x >= 0
        var x = if (sign) { x } else { -x }
        var y = 0

        while (x > 9) {
            val d = x % 10
            if (y > Int.MAX_VALUE / 10 || (y == Int.MAX_VALUE / 10 && d > 7))
                return 0

            y *= 10
            y += d
            x /= 10
        }

        if (y > Int.MAX_VALUE / 10 || (y == Int.MAX_VALUE / 10 && x > 7))
            return 0

        y *= 10
        y += x

        return if (sign) { y } else { -y }
    }
}