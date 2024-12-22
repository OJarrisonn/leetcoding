package com.harrisonn.`2024`.`12`

class Solution {
    data class TrieNode(val next: MutableMap<Char, TrieNode>, var count: Int, var path: Boolean = false)

    companion object{fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        strs.sortBy { it.length }

        var slice = 0

        done@for (i in 0..<strs[0].length) {
            val c = strs[0][i]
            for (s in strs.indices) {
                if (strs[s][i] != c) {
                    break@done
                }
            }
            slice++
        }

        return strs[0].substring(0, slice)
    }}
}

fun main() {
    println(Solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}