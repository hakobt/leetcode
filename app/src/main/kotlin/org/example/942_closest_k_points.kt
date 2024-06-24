package org.example

import java.util.PriorityQueue
import kotlin.math.sqrt

class ClosestKPoints {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<DistanceWithItems>()

        points.forEach {
            val x = it[0]
            val y = it[1]
            val distance = sqrt((x * x + y * y).toDouble())
            heap.add(
                DistanceWithItems(distance, it)
            )
        }

        val resultArray = Array<IntArray>(k) {
            heap.poll().xy
        }
        return resultArray
    }

    class DistanceWithItems(
        val distance: Double,
        val xy: IntArray
    ) : Comparable<DistanceWithItems> {
        override fun compareTo(other: DistanceWithItems): Int {
            return this.distance.compareTo(other.distance)
        }
    }
}