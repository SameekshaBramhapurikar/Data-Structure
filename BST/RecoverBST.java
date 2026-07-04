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
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;


    public void inorder(TreeNode root)
    {
         if(root == null)
        {
            return;
        }
        inorder(root.left);

        if(prev != null && (root.data < prev.data))
            if(first == null)
            {
                first=prev;
                middle=root;
            }
            else 
            {
                last=root;
            }
        prev= root;
        inorder(root.right);
    }
    void recoverTree(TreeNode root) {

        first=middle=last=null;
        prev= new TreeNode(Integer.MIN_VALUE);
        inorder (root);
        if(first != null && last != null)
        {
            int t=first.data;
            first.data=last.data;
            last.data=t;
        }
        else if(first!=null && middle != null)
        {
            int t=first.data;
            first.data=middle.data;
            middle.data=t;

        }
    }
}
