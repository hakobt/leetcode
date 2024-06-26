package org.example

class ThreeSum {
  // [-1,0,1,2,-1,-4]
  // [-4,-1,-1,0,1,2]
  fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()
    for (i in nums.indices) {
      var leftIndex = i + 1
      var rightIndex = nums.lastIndex
      if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
        continue
      }
      while (leftIndex < rightIndex) {
        val sum = nums[leftIndex] + nums[rightIndex] + nums[i]
        if (sum > 0) {
          rightIndex--
        } else if (sum < 0) {
          leftIndex++
        } else {
          result.add(listOf(nums[i], nums[leftIndex], nums[rightIndex]))
          while (nums[++leftIndex] == nums[leftIndex-1] && leftIndex < rightIndex) {}
        }
      }
    }

    return result
  }

}