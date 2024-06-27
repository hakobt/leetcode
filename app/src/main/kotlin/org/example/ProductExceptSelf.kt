class ProductExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var runningProduct = 1
        for (i in 0..nums.lastIndex) {
            result[i] = runningProduct
            runningProduct *= nums[i]
        }

        runningProduct = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] *= runningProduct
            runningProduct *= nums[i]
        }

        return result
    }
}