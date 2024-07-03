package org.example

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class GraphNode(var `val`: Int) {
    var neighbors: ArrayList<GraphNode?> = ArrayList<GraphNode?>()
}