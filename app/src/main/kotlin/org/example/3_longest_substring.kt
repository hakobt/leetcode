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
            max = maxOf(max, i - windowStart)
            if (!charToIndex.containsKey(s[i])) {
                charToIndex[s[i]] = i
                i++
                max = maxOf(max, i - windowStart)
            } else {
                val indexOfRepeatedChar = charToIndex[s[i]]!!
                windowStart = indexOfRepeatedChar + 1
                charToIndex[s[i]] = i
                i++
            }
            println(charToIndex)
            println("Max: $max")
            println("Windowstart: $windowStart")
            println("Index: $i")
            println("-------------")
        }
        
        max = maxOf(max, i - windowStart)

        return max
    }
}