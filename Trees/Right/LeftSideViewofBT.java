//Right Side View 
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
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> res=new LinkedList<>();
       rightSideView(root,0,res);
       return res;
        
    }
    private void rightSideView(TreeNode node,int level, List<Integer> ans)
    {
        if(node==null)
        {
            return;
        }
        if(level==ans.size())
        {
            ans.add(node.data);
        }
        rightSideView(node.right,level+1,ans);
        rightSideView(node.left,level+1,ans);
    }
}
//Left Side View
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
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> res=new LinkedList<>();
       rightSideView(root,0,res);
       return res;
        
    }
    private void rightSideView(TreeNode node,int level, List<Integer> ans)
    {
        if(node==null)
        {
            return;
        }
        if(level==ans.size())
        {
            ans.add(node.data);
        }
        rightSideView(node.left,level+1,ans);
        rightSideView(node.right,level+1,ans);
    }
}
