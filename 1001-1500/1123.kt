fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    fun getDepth(root: TreeNode?): Int {
        if (root == null) return 0

        return maxOf(getDepth(root.left), getDepth(root.right)) + 1
    }
    
    val deepest = getDepth(root)
    
    fun getLCA(root: TreeNode?, depth: Int): TreeNode? {
        // base case
        if (root == null) return null

        if (depth == deepest)  return root

        // divide
        val left = getLCA(root.left, depth + 1)
        val right = getLCA(root.right, depth + 1)
        
        // conquer
        return when {
            left != null && right != null -> root
            left != null -> left
            else -> right
        }
    }
    
    return getLCA(root, 1)
}

// C++

TreeNode* lcaDeepestLeaves(TreeNode* root) {
    int depth = getDepth(root);
    return getLCA(root, 1, depth);
}

int getDepth(TreeNode* root) {
    if (root == nullptr) return 0;
    return max(getDepth(root->left), getDepth(root->right)) + 1;
}

TreeNode* getLCA(TreeNode* root, int level, int depth) {
    if (root == nullptr) return nullptr;
    if (depth == level) return root;

    auto left = getLCA(root->left, level + 1, depth);
    auto right = getLCA(root->right, level + 1, depth);
    
    if (left != nullptr && right != nullptr) return root;
    else if (left != nullptr) return left;
    else return right;
}
