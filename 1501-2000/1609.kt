class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        val q = LinkedList<TreeNode?>()
        q.offer(root)
        var level = 0
        while (q.isNotEmpty()) {
            val isEven = level and 1 == 0
            var prev = if (isEven) Int.MIN_VALUE else Int.MAX_VALUE
            for (i in 0 until q.size) {
                val child = q.poll() ?: continue
                if (isEven) {
                    if (prev >= child.`val`) return false
                    if (child.`val` and 1 == 0) return false
                } else {
                    if (prev <= child.`val`) return false
                    if (child.`val` and 1 == 1) return false
                }
                prev = child.`val`
                child.left?.let { q.offer(it) }
                child.right?.let { q.offer(it) }
            }
            level++
        }
        return true
    }
}
