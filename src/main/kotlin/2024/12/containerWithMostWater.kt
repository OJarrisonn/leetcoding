package com.harrisonn.`2024`.`12`

import kotlin.math.min

class CWMostWaterSolution {
    companion object{fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var m = 0

        fun area(i: Int, j: Int) = (j-i)*min(height[i], height[j])

        while (i < j) {
            val a = area(i, j)
            if (a > m) m = a

            if (height[i] < height[j]) i++
            else j--
        }

        return m
    }}
}

fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    println(CWMostWaterSolution.maxArea(height))
}