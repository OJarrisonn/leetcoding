package com.harrisonn.`2024`.`12`

class MO2SASolution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val merged = IntArray(m + n)
        var p1 = 0
        var p2 = 0
        var p = 0

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                merged[p] = nums1[p1]
                p1++
            } else {
                merged[p] = nums2[p2]
                p2++
            }
            p++
        }

        while (p1 < m) {
            merged[p] = nums1[p1]
            p1++
            p++
        }
        while (p2 < n) {
            merged[p] = nums2[p2]
            p2++
            p++
        }

        return median(merged)
    }

    fun median(nums: IntArray): Double {
        val l = nums.size

        return if (l % 2 == 0) {
            (nums[l/2] + nums[l/2-1]).toDouble() / 2
        } else {
            nums[l/2].toDouble()
        }
    }
}