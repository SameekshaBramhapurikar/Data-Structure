/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public int inOrderSuccessor(Node root, Node k) {
        int successor= -1;
        
        while(root!=null)
        {
            if(k.data >= root.data)
            {
                root=root.right;
            }
            else 
            {
                successor=root.data;
                root=root.left;
            }
        }
        return successor;
    }
}
