fun findBoundary(
    arr: List<Boolean>
): Int {

    var left = 0
    var right = arr.lastIndex
    var boundaryIndex = -1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (!arr[mid]) {
            left = mid + 1
        } else if (arr[mid]) {
            right = mid - 1
            boundaryIndex = mid
        }
    }
    return boundaryIndex
}

fun firstNotSmaller(arr: List<Int>, target: Int): Int {
    var left = 0
    var right = arr.lastIndex
    var minIndex = -1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (arr[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
            minIndex = mid
        }
    }

    return minIndex
}

//Given a sorted array of integers and a target integer,
//find the first occurrence of the target and return its index.
//Return -1 if the target is not in the array.
fun firstOccurence(arr: List<Int>, target: Int): Int {
    var index = -1
    var left = 0
    var right = arr.lastIndex
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (arr[mid] == target) {
            index = mid
            right = mid - 1
        } else if (arr[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return index
}

fun squareRootEstimation(n: Int): Int {
    var left = 0
    var right = n
    var sqrt = -1
    while (left < right) {
        var mid = left + (right - left) / 2
        if (mid == n / mid) {
            return mid
        } else if (mid > n / mid) {
            sqrt = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    
    return sqrt - 1
}

fun main() {
    println(
        firstOccurence(
            listOf(10, 11, 12, 13),
            10
        )
    )
}