/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author mehul
 */
//one method is to use hashing but the space complexity will become really large.
//just xor all the elements to get the remaining one
public class TreeHeight {
    static Node root;
    public static void main(String args[]){
        TreeHeight tree = new TreeHeight();
 
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Height of tree is : " + tree.maxDepth(root));
    }
    
    static int maxDepth(Node root){
        if(root == null)
            return 0;
        int height = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return height;
    }
}

class Node {
 
    int data;
    Node left, right;
 
    Node(int item) {
        data = item;
        left = right = null;
    }
}
