package org.example

fun merge(intervals: Array<IntArray>): Array<IntArray> {

  intervals.sortBy { it[0] }

  val result = mutableListOf<IntArray>()

  // [[1,3],[2,6],[8,10],[15,18]]
  // [1,5], [2,3]
  var i = 1
  var previousInterval = intervals[0]
  result.add(previousInterval)
  while (i <= intervals.lastIndex) {
    if (previousInterval[1] >= intervals[i][0]) {
      previousInterval[1] = maxOf(previousInterval[1], intervals[i][1])
    } else {
      result.add(intervals[i])
      previousInterval = intervals[i]
    }
    i++
  }

  return result.toTypedArray()
}