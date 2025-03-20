package wise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        System.out.println("result: " + binaryTreeInorderTraversal.inorderTraversalIterative(root));
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        // Uses: Performs an inorder traversal (Left → Node → Right) iteratively using a stack.
        // Pros:
        // - Avoids recursion, reducing risk of stack overflow in deep trees.
        // - Runs in O(n) time, which is optimal for tree traversal.
        // - Works for both balanced and unbalanced trees.

        // Cons:
        // - Uses extra space due to the stack (O(h) space complexity).
        // - More complex than a recursive approach, which is simpler to write.

        // Time Complexity: O(n) - Every node is visited exactly once.
        // Space Complexity: O(h), where h is the tree height.
        // - O(log n) for a balanced tree (best case).
        // - O(n) for a completely unbalanced tree (worst case).

        // Avoids recursion, which can cause stack overflow in deep trees.
        //new list of ints
        //sttack nodes
        //current is root
        //while current not null and stack not empty
            //current not null
                //add to stack
                //move current to left
            //pop crrent
            //add ot list
            //check right
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){//go down left side till end
            while(curr !=null){
                stack.add(curr);//at end add to stack
                curr=curr.left;//go left
            }
            curr = stack.pop();//take last node when next elft is null
            list.add(curr.val);//add value to list
            curr = curr.right;//go right now
        }
        return list;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        // Uses: Performs an inorder traversal (Left → Node → Right) recursively.
        // Simple and intuitive approach using recursion.

        // Pros:
        // - Simple and intuitive approach.
        // - No need for explicit stack management, recursion handles it automatically.
        // - Works well for small to moderately deep trees.

        // Cons:
        // - Uses implicit recursion stack, which can cause stack overflow for deep trees.
        // - In the worst case (unbalanced tree), recursion depth can reach O(n).

        // Time Complexity: O(n) - Each node is visited exactly once.
        // Space Complexity: O(h), where h is the tree height (due to recursive call stack).
        // - O(log n) for a balanced tree (best case).
        // - O(n) for a completely unbalanced tree (worst case).
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if(root==null){
            return;//edge
        }
        traverse(root.left);//till end
        res.add(root.val);//when at end
        traverse(root.right);
    }
}
