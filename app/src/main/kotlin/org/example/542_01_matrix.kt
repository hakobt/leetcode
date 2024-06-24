package org.example

import kotlin.math.min

class Matrix01 {

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {

        val max = 100000
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    continue
                }
                var top = max
                var left: Int = max
                if (i - 1 >= 0) {
                    top = mat[i - 1][j]
                }
                if (j - 1 >= 0) {
                    left = mat[i][j - 1]
                }
                mat[i][j] = minOf(top, left) + 1
            }
        }

        for (i in mat.lastIndex downTo 0) {
            for (j in mat[i].lastIndex downTo 0) {
                if (mat[i][j] == 0) {
                    continue
                }
                var right: Int = max
                var bottom: Int = max
                if (i + 1 <= mat.lastIndex) {
                    bottom = mat[i + 1][j]
                }
                if (j + 1 <= mat[i].lastIndex) {
                    right = mat[i][j + 1]
                }
                mat[i][j] = minOf(mat[i][j], minOf(right, bottom) + 1)
            }
        }
        return mat
    }

}