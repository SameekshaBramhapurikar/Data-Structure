// class TreeNode {
//     int val;
//     TreeNode left, right;
//     TreeNode(int x) { val = x; }
// }

class Solution {
    boolean checkChildrenSum(TreeNode root) { 
       if(root == null)
       {
        return true;
       }
        if(root.left==null &&  root.right==null)
        {
            return true;
        }
       
        

        int tot=0;
        if(root.left!=null)
            tot+=root.left.val;
        if(root.right!=null)
            tot+=root.right.val;

        return(root.val==tot)
            && checkChildrenSum(root.left)
            && checkChildrenSum(root.right);

    }
}
