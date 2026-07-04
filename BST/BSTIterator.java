/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class BSTIterator {
        Stack <TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
           pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode tmpNode=stack.pop();
            pushAll(tmpNode.right);
            return tmpNode.data;
        }
        public void pushAll(TreeNode root)
        {
            for(; root != null ; stack.push(root),root=root.left);
                
        }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
