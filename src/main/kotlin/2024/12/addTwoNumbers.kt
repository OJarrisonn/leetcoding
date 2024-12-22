package com.harrisonn.`2024`.`12`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ATNSolution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carryOn = 0
        var l1 = l1
        var l2 = l2
        var result: ListNode? = null
        var current = result

        while (carryOn != 0 || l1 != null || l2 != null) {
            val sum = carryOn + (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
            val digit = sum % 10

            carryOn = sum / 10
            l1 = l1?.next
            l2 = l2?.next

            when (current) {
                null -> {
                    result = ListNode(digit)
                    current = result
                }
                else -> {
                    current.next = ListNode(digit)
                    current = current.next
                }
            }
        }

        return result
    }
}