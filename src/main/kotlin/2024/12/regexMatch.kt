package com.harrisonn.`2024`.`12`

class RegexMatchSolution {
    companion object {
        fun isMatch(s: String, p: String): Boolean {
            var pi = 0

            fun matches(c: Char): Boolean = p.getOrNull(pi) == '.' || p.getOrNull(pi) == c
            fun isStared(): Boolean = p.getOrNull(pi + 1) == '*'

            for (c in s) {
                if (pi >= p.length) return false

                val matched = matches(c)

                if (!matched) {
                    if (!isStared()) return false
                    else while (isStared()) {
                        pi += 2
                        if (matches(c)) {
                            if (!isStared()) pi += 1
                            break
                        }
                    }
                } else {
                    if (!isStared()) {
                        pi += 1
                    }
                }
            }

            while (isStared()) pi += 2

            return pi >= p.length
        }
    }
}

fun main() {
    println(RegexMatchSolution.isMatch("mississippi", "mis*is*ip*."))
}