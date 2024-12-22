package com.harrisonn.`2024`.`12`

class LPSSolution {
    fun longestPalindrome(s: String): String {
        var len = s.length

        while (len > 0) {
            for (i in 0..(s.length-len)) {
                val slice = s.slice(i..<(i+len))
                if (isPalindrome(slice)) { return slice }
            }
            len--
        }

        return ""
    }

    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while (l < r) {
            if (s[l] != s[r]) return false

            l++
            r--
        }

        return true
    }

    class TOP1 {
        fun longestPalindrome(s: String): String {
            var p = 0 to 0
            val lp = {-> p.second - p.first}

            for (i in s.indices) {
                val x = flood(s, i, i)
                val y = flood(s, i, i+1)
                val lx = x.second - x.first
                val ly = y.second - y.first

                if (lx > ly) {
                    if (lx > lp()) p = x
                } else {
                    if (ly > lp()) p = y
                }
            }

            return s.slice(p.first..p.second)
        }

        fun flood(s: String, start: Int, end: Int): Pair<Int, Int> {
            var start = start
            var end = end

            while (start >= 0 && end < s.length && s[start] == s[end]) {
                start--
                end++
            }

            return (start + 1) to (end - 1)
        }
    }
}