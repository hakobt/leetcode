package org.example

class ReversePolishNotation {

    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>(tokens.size)
        tokens.forEach { token ->
            when (token) {
                "+" -> {
                    stack.addLast(stack.removeLast() + stack.removeLast())
                }
                "*" -> {
                    stack.addLast(stack.removeLast() * stack.removeLast())
                }
                "-" -> {
                    val right = stack.removeLast()
                    val left: Int = stack.removeLast()
                    stack.addLast(left - right)
                }
                "/" -> {
                    val right = stack.removeLast()
                    val left: Int = stack.removeLast()
                    stack.addLast(left / right)
                }
                else -> {
                    stack.addLast(token.toInt())
                }
            }
        }

        return stack.removeLast()
    }

}