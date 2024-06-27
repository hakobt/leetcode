package org.example

import java.math.BigDecimal

fun maxProduct(nums: IntArray): Int {
    val prefix = arrayOfNulls<BigDecimal>(nums.size)
    val postfix = arrayOfNulls<BigDecimal>(nums.size)

    var runningProduct = 1.toBigDecimal()
    for (i in 0..nums.lastIndex) {
        runningProduct *= nums[i].toBigDecimal()
        prefix[i] = runningProduct
        if (runningProduct == 0.toBigDecimal()) {
            runningProduct = 1.toBigDecimal()
        }
    }

    runningProduct = 1.toBigDecimal()
    for (i in nums.lastIndex downTo 0) {
        runningProduct *= nums[i].toBigDecimal()
        postfix[i] = runningProduct
        if (runningProduct == 0.toBigDecimal()) {
            runningProduct = 1.toBigDecimal()
        }
    }

    return maxOf(prefix.filterNotNull().max(), postfix.filterNotNull().max()).toInt()
}