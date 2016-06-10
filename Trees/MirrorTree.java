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
public class MirrorTree {
    static Node root;
    public static void main(String args[]){
        MirrorTree tree = new MirrorTree();
        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        Node temp = root;
        inOrder(temp);
        System.out.println();
        mirror(root);
        inOrder(root);
    }
    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    public static void mirror(Node root){
        if(root != null){
            mirror(root.left);
            
            mirror(root.right);
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            
        }
    }
    
}

class Node {
 
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = right = null;
    }
}