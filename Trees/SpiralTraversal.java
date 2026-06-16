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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans= new ArrayList<List<Integer>>();
       if(root==null)
       {
        return ans;
       }

       Queue<TreeNode> queue=new LinkedList<>();
       int flag=0;

       queue.add(root);

       while(!queue.isEmpty())
       {
        List<Integer> temp=new ArrayList<>();
        int n=queue.size();

        for(int i=0;i<n;i++)
        {
            TreeNode node=queue.poll();
            temp.add(node.data);

            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

        if(flag==1)
        {
            Collections.reverse(temp);
            ans.add(temp);
            flag=0;
        }
        else
        {
            ans.add(temp);
            flag=1;
        }
       }

        return ans;
    }
}
