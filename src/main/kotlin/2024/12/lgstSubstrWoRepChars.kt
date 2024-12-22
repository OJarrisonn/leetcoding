package com.harrisonn.`2024`.`12`

class LSWRCSolution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) return s.length

        var start = 0
        var end = 1
        var hs = 0
        val chars = mutableSetOf<Char>()

        while (end < s.length || end - start > hs) {
            val next = s[end-1]

            if (next in chars) {
                chars.remove(s[start])
                start += 1
            } else {
                chars.add(next)
                val newhs = end - start
                if (newhs > hs) hs = newhs
                if (end < s.length) end += 1
            }
        }

        return hs
    }

    fun lengthOfLongestSubstring2(s: String): Int {
        if (s.length < 2) return s.length

        var start = 0
        var end = 1
        var hs = 0
        val chars = BooleanArray(256)

        while (end < s.length || end - start > hs) {
            val next = s[end-1]

            if (chars[next.code]) {
                chars[s[start].code] = false
                start += 1
            } else {
                chars[next.code] = true
                val newhs = end - start
                if (newhs > hs) hs = newhs
                if (end < s.length) end += 1
            }
        }

        return hs
    }
}