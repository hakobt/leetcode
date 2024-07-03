package org.example

class Node<T>(
  var value: T,
  var left: Node<T>? = null,
  var right: Node<T>? = null
)


fun treeMaxDepth(root: Node<Int>?): Int {
  if (root == null) {
    return 0
  }

  fun dfs(root: Node<Int>?): Int {
    if (root == null) {
      return 0
    }
    val left = dfs(root.left)
    val right = dfs(root.right)
    return maxOf(left, right) + 1
  }

  return dfs(root) - 1
}

//Given a binary tree, count the number of "visible" nodes.
fun visibleTreeNode(node: Node<Int>): Int {

  fun dfs(root: Node<Int>?, maxSoFar: Int): Int {
    if (root == null) {
      return 0
    }
    var total = 0
    if (root.value >= maxSoFar) {
      total++
    }
    val left = dfs(root.left, maxOf(root.value, maxSoFar))
    val right = dfs(root.right, maxOf(root.value, maxSoFar))
    total += left + right
    return total
  }

  return dfs(node, Int.MIN_VALUE)
}

// given a binary tree, determine if it is balanced.
fun isBalanced(root: Node<Int>): Boolean {

  fun dfs(root: Node<Int>?): Int {
    if (root == null) {
      return 0
    }

    val left = dfs(root.left)
    val right = dfs(root.right)
    if (left == -1 || right == -1) {
      return -1
    }
    if (abs(left - right) > 1) {
      return -1
    }
    
    

    return maxOf(left, right) + 1
  }

  return dfs(root) != -1
}

fun deserializeDFS(nodes: Iterator<String>): Node<Int>? {
  val n = nodes.next()
  if (n == "x") {
    return null
  }
  val current = Node(n.toInt())
  current.left = deserializeDFS(nodes)
  current.right = deserializeDFS(nodes)
  return current
}

fun serializeDFS(root: Node<Int>?, builder: StringBuilder) {
  if (root == null) {
    builder.append("x")
    return
  }
  builder.append(root.value.toString())
  serializeDFS(root.left, builder)
  serializeDFS(root.right, builder)
}

fun invertBinaryTree(root: Node<Int>?): Node<Int>? {
  if (root == null) {
    return null
  }

  val left = invertBinaryTree(root.left)
  val right = invertBinaryTree(root.right)
  root.right = left
  root.left = right
  return root
}