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
    public int countNodes(TreeNode root) {
       if(root == null)
       {
        return 0;
       }
       int left=findheightLeft(root);
       int right=findHeightRight(root);
       if(left==right)
       {
            return ((2<<(left)) -1);
       }
       else
       {
        return countNodes(root.left) + countNodes(root.right)+1;
       }
    }
    public int findheightLeft(TreeNode root)
    {
        int cnt=0;
        while(root.left!=null)
        {
            cnt++;
            root=root.left;
        }
        return cnt;
    }
    public int findHeightRight(TreeNode root)
    {
        int cnt=0;
        while(root.right!=null)
        {
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}
