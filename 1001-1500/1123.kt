/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        val parents = mutableMapOf<TreeNode, TreeNode?>()
        val depths = mutableMapOf<TreeNode, Int>()
        
        fun dfs(node: TreeNode?, parent: TreeNode?, depth: Int) {
            if (node == null) {
                return
            }
            
            parents[node] = parent
            depths[node] = depth
            dfs(node.left, node, depth + 1)
            dfs(node.right, node, depth + 1)
        }
        
        dfs(root, null, 0)
        
        var maxDepth = 0
        for ((_, depth) in depths) {
            maxDepth = max(maxDepth, depth)
        }
        
        val maxDepthNodes = mutableSetOf<TreeNode>()
        for ((node, depth) in depths) {
            if (depth == maxDepth) {
                maxDepthNodes.add(node)
            }
        }
        
        while (maxDepthNodes.size > 1) {
            val newNodes = mutableSetOf<TreeNode>()
            for (node in maxDepthNodes) {
                parents[node]?.let { 
                    newNodes.add(it) 
                }
            }
            maxDepthNodes.clear()
            maxDepthNodes.addAll(newNodes)
        }
        
        return maxDepthNodes.last()
    }
}
