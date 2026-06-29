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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
       List<Integer> res= new ArrayList<>();
       int ceil=-1;
       int floor =-1;
       TreeNode curr=root;

        while(curr != null)
        {
                
            if(curr !=null)
            {
                    if(curr.data == key)
                    {
                        floor=curr.data;
                        break;   
                    }
            }
            if(curr.data < key)
            {
                    floor=curr.data;
                    curr=curr.right;
            }
            else
            {
                    curr=curr.left;
            }
        }

        
       curr=root;
       while(curr != null)
       {
        if(curr!=null)
        {
                if(curr.data == key)
                {
                    ceil=curr.data;
                    break;
                    
                }
        }
        if(curr.data > key)
        {
            ceil=curr.data;
            curr=curr.left;
        }
        else
        {
                curr=curr.right;
        }
       }

       res.add(floor);
       res.add(ceil);
       return res;
    }
}
