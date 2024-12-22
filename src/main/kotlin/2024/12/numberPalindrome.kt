package com.harrisonn.`2024`.`12`

class NumPalinSolution {
    companion object {
        fun isPalindrome(x: Int): Boolean {
            // Negative numbers and numbers that end on 0 aren't palindromes
            if (x < 0 || x % 10 == 0 && x != 0) return false
            // Single digit are palindromes
            if (x < 10) return true

            var x = x
            var y = 0

            while (x - y > 9) {
                if (x / 10 == y) return true
                y *= 10
                y += x % 10
                x /= 10
            }

            return x == y || x / 10 == y
        }
    }
}

fun main() {
    println(NumPalinSolution.isPalindrome(101))
}
