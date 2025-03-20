package wise;

public class LowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left  = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println("result: " + lowestCommonAncestor.lowestCommonAncestorRecursive(root, root.left, root.right));
    }
    /**
     * Finds the Lowest Common Ancestor (LCA) of two given nodes in a Binary Tree.
     *
     * @param root The root of the binary tree.
     * @param p First node.
     * @param q Second node.
     * @return The LCA of nodes p and q.
     *
     * Time Complexity: O(N) - Since we traverse each node once in the worst case.
     * Space Complexity: O(H) - Due to recursive call stack, where H is the height of the tree.
     *    - Best case (balanced tree): O(log N)
     *    - Worst case (skewed tree): O(N)
     */
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){//if top then has to include both
            return root;
        }
        TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);//check left tree
        TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);//then right
        return left == null ? right : right == null ? left : root;//if end left, go right, same check, if not root
    }
    /*
     * ✅ Function: Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).
     *
     * 🔹 Approach:
     *    - Utilizes BST properties where left subtree nodes < root < right subtree nodes.
     *    - Iteratively navigates down the tree to find the LCA.
     *
     * 🔹 Logic:
     *    - If both `p` and `q` are smaller than `root`, move left.
     *    - If both `p` and `q` are greater than `root`, move right.
     *    - If `p` and `q` are on different sides (or one equals `root`), return `root` as LCA.
     *
     * ⏳ Time Complexity: O(H)  -> H = height of the tree
     *    - Best case (Balanced BST): O(log N)
     *    - Worst case (Skewed BST): O(N)
     *
     * 🛠 Space Complexity: O(1) -> Constant space (no recursion stack)
     *
     * ✅ Pros:
     *    - Efficient (O(1) space) compared to recursive approach (O(H) space).
     *    - Avoids stack overflow issues from deep recursion.
     *    - Simple and fast for BSTs.
     *
     * ❌ Cons:
     *    - Only works for Binary Search Trees (BSTs), NOT general binary trees.
     *    - Requires BST property (ordered nodes).
     *
     * 🚀 Use Cases:
     *    - Searching for LCA in a BST (e.g., hierarchical databases, organizational trees).
     *    - Ideal when recursion is undesirable due to memory constraints.
     */
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)//if root is larger than p and q, then contains both!
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
