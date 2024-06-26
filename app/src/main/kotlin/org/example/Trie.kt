class Trie {
    val root = TrieNode(char = ' ', false)

    fun insert(word: String) {
        var current = root
        word.forEachIndexed { index, c ->
            val nextNode = current.getNode(c)
            if (nextNode != null) {
                current = nextNode
                if (index == word.lastIndex) {
                    current.isWordEnd = true
                }
            } else {
                current = current.insertNode(c, index == word.lastIndex)
            }
        }
    }

    fun search(word: String): Boolean {
        var current: TrieNode? = root
        for (index in word.indices) {
            val c = word[index]
            val node = current?.getNode(c)
            current = node
        }
        return current?.isWordEnd == true
    }

    fun startsWith(prefix: String): Boolean {
        var current: TrieNode? = root
        for (index in prefix.indices) {
            val c = prefix[index]
            current = current?.getNode(c)
        }
        return current != null && current !== root
    }
}

class TrieNode(
    val char: Char,
    var isWordEnd: Boolean
) {
    val children: Array<TrieNode?> = arrayOfNulls(26)

    fun getNode(c: Char): TrieNode? {
        val index = c - 'a'
        return children[index]
    }

    fun insertNode(c: Char, isWordEnd: Boolean): TrieNode {
        val index = c - 'a'
        val node = TrieNode(c, isWordEnd)
        children[index] = node
        return node
    }
}