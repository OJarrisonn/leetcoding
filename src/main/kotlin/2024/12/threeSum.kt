package com.harrisonn.`2024`.`12`

class ThreeSumSolution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val index = mutableMapOf<Int, MutableSet<Int>>()
        val result = mutableListOf<List<Int>>()
        var lastI = Int.MIN_VALUE
        var lastJ = Int.MIN_VALUE

        for (i in nums.indices) {
            if (index[nums[i]] == null) {
                index[nums[i]] = mutableSetOf(i)
            } else {
                index[nums[i]]?.add(i)
            }
        }

        for (i in nums.indices) {
            if (nums[i] == lastI) continue
            else lastI = nums[i]

            for (j in i + 1..<nums.size) {
                if (nums[j] == lastJ) continue
                else lastJ = nums[j]

                val sum = nums[i] + nums[j]
                val complement = index[-sum]

                if (complement != null && complement.any { it > i && it > j }) {
                    result.add(listOf(nums[i], nums[j], -sum))
                }
            }
        }

        return result
    }
}