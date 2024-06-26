package org.example

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val queue = ArrayDeque<TreeNode>()
    if (root == null) {
        return emptyList()
    }
    queue.addLast(root)
    val result = mutableListOf<MutableList<Int>>()
    while (queue.isNotEmpty()) {
        val size = queue.size
        val currentList = mutableListOf<Int>()
        for (i in 0..queue.lastIndex) {
            val node = queue.removeFirst()
            currentList.add(node.`val`)
            if (node.left != null) {
                queue.addLast(node.left!!)
            }
            if (node.right != null) {
                queue.addLast(node.right!!)
            }
        }
        result.add(currentList)
    }
    return result
}
