package org.example


fun canFinish(
    numCourses: Int,
    prerequisites: Array<IntArray>
): Boolean {
    val connections = hashMapOf<Int, Int>()

    prerequisites.forEach {
        connections[it[0]] = it[1]
    }

    return false
}