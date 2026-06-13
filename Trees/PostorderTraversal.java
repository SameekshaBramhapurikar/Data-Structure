//using two stacks 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> st1= new Stack<TreeNode>();
        Stack<TreeNode> st2= new Stack<TreeNode>();
        if(root==null)
        {
            return list;
        }

        st1.push(root);
        while(!st1.isEmpty())
        {
            root=st1.pop();
            st2.add(root);
            if(root.left!=null)
                st1.push(root.left);
            if(root.right!=null)
                st1.push(root.right);   
        }
        while(!st2.isEmpty())
        {
            list.add(st2.pop().val);
        }
        return list;
    }
}

//using 1 stack 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr=root;
        TreeNode temp;
        Stack<TreeNode> st=new Stack<TreeNode>();
        List<Integer> list=new ArrayList<Integer>();

        while(curr!=null || !st.isEmpty())
        {
            if(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
            else 
            {
                temp=st.peek().right;
                if(temp == null)
                {
                    temp=st.peek();
                    st.pop();
                    list.add(temp.val);

                    while(!st.isEmpty() && temp==st.peek().right)
                    {
                        temp=st.peek();
                        st.pop();
                        list.add(temp.val);
                    }
                }
                else 
                {
                    curr=temp;
                }
                
        }
        }
        return list;
    }
}
    }
}
