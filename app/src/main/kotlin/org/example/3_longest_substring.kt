package org.example

class LongestSubstring {

  fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) {
      return 0
    }
    val charToIndex = mutableMapOf<Char, Int>()
    charToIndex[s[0]] = 0

    var windowStart = 0
    var max = 1
    var i = 1

    while (i < s.length) {
      if (charToIndex.contains(s[i])) {
        windowStart = maxOf(charToIndex[s[i]]!! + 1, windowStart)
      }

      charToIndex[s[i]] = i
      max = maxOf(max, i - windowStart + 1)
      i++
    }

    return max
  }
}