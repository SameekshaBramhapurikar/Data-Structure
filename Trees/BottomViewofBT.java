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
    class Node
    {
            int data;
            Node left,right;
            int hd;

            Node(int item)
            {
                data=item;
                left=right=null;
                hd=0;
            }
    }
    private Node convert(TreeNode root) {
        if (root == null) return null;
        Node node = new Node(root.data);
        node.left = convert(root.left);
        node.right = convert(root.right);
        return node;
    }
    public List<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();

        if(root==null)
        {
            return ans;
        }
        Node customRoot=convert(root);
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Node> q=new LinkedList<Node>();
        customRoot.hd=0;
        q.add(customRoot);
        while(!q.isEmpty())
        {
            Node temp=q.remove();
            int hd=temp.hd;
            map.put(hd,temp.data);
            if(temp.left!=null)
            {
                temp.left.hd=hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
