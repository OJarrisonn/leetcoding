package com.harrisonn.`2024`.`12`

class I2RomanSolution {
    fun intToRoman(num: Int): String {
        val I = arrayOf("","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
        val X = arrayOf("","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        val C = arrayOf("","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        val M = arrayOf("","M", "MM", "MMM")

        val builder = StringBuilder()

        val m = num / 1000
        val c = num / 100 % 10
        val x = num / 10 % 10
        val i = num % 10

        if (m > 0) {
            builder.append(M[m])
        }

        if (c > 0) {
            builder.append(C[c])
        }

        if (x > 0) {
            builder.append(X[x])
        }

        if (i > 0) {
            builder.append(I[i])
        }

        return builder.toString()
    }
}