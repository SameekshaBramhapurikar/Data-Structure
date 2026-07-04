/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
class NodeValue
{
    public int minNode,maxNode,maxSize;

    NodeValue(int maxNode,int minNode,int maxSize)
    {
        this.maxNode=maxNode;
        this.minNode=minNode;
        this.maxSize=maxSize;
    }
}
class Solution {
        private NodeValue largestBSTHelper(TreeNode root)
        {
            if(root == null)
            {
                return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
            }
            NodeValue left=largestBSTHelper(root.left);
            NodeValue right=largestBSTHelper(root.right);

            if(left.maxNode < root.data && root.data < right.minNode)
            {
                return new NodeValue(Math.max(root.data,right.maxNode),Math.min(root.data,left.minNode),left.maxSize + right.maxSize + 1);
            }

            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxSize,right.maxSize));
        }

        public int largestBST(TreeNode root) {
            return largestBSTHelper(root).maxSize;
        }
}
