/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricTree(root.left,root.right);
    }
    private boolean isSymmetricTree(TreeNode left,TreeNode right)
    {
        if(left==null || right==null)
        {
            return left==right;
        }
        if(left.data!=right.data)
            return false;
        return isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
    }
}
