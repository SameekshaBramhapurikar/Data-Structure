/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans= new ArrayList<>();
        Node successor=null;
        Node predecessor=null;
        Node curr=root;
        
        //predecessor
        while(curr != null)
        {
            if(key > curr.data)
            {
                predecessor=curr;
                curr=curr.right;
            }
            else 
            {
                curr=curr.left;
            }
        }
        //successor
        curr=root;
        while(curr != null)
        {
            if(key < curr.data)
            {
                 successor=curr;
                curr=curr.left;
                
            }
            else 
            {
               curr=curr.right;
            }
        }
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }
}
