class InsertInterval {
    fun insert(
        intervals: Array<IntArray>,
        newInterval: IntArray
    ): Array<IntArray> {

        val resultArray = mutableListOf<IntArray>()
        var newInterval = newInterval
        for (interval in intervals) {
            if (newInterval[1] < interval[0]) {
                resultArray.add(newInterval)
                newInterval = interval
            } else if (newInterval[0] > interval[1]) {
                resultArray.add(interval)
            } else {
                newInterval[0] = minOf(newInterval[0], interval[0])
                newInterval[1] = maxOf(newInterval[1], interval[1])
            }
        }
        
        resultArray.add(newInterval)
        
        return resultArray.toTypedArray()
    }
}