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
        boolean reverse=true;

        public BSTIterator(TreeNode root,boolean isReverse) {
           reverse=isReverse;
           pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode tmpNode=stack.pop();
            if(reverse == false)
            {
                pushAll(tmpNode.right);
            }
            else 
            {
                 pushAll(tmpNode.left);
            }
            return tmpNode.data;
        }
        public void pushAll(TreeNode node)
        {
           while(node != null)
           {
                stack.push(node);
                if(reverse == true)
                {
                    node=node.right;
                }
                else 
                {
                    node=node.left;
                }
            }
                
        }
}
class Solution {
    public boolean twoSumBST(TreeNode root, int k) {
       if(root == null)
       {
        return false;
       }
       BSTIterator l=new BSTIterator(root,false);
       BSTIterator r= new BSTIterator(root,true);

       int i=l.next();
       int j=r.next();

       while( i < j)
       {
        if(i+j == k)
        {
            return true;
        }
        else if( i+j < k)
        {
            i=l.next();
        }
        else 
        {
            j=r.next();
        }
       }

       return false;
           
    }
}
