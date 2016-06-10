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
public class TreePaths {
    static Node root;
    public static void main(String args[]){
        TreePaths
     tree = new TreePaths
        ();
        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        Node temp = root;
        int arr[] = new int[100];
        int i = 0;
        numPaths(temp, arr, 0);
       
        //inOrder(root);
    }
    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
    static void numPaths(Node temp, int arr[], int len){
        if(temp == null)
            return;
        arr[len] = temp.data;
        if(temp.left == null && temp.right == null)
            print(arr, len);
        numPaths(temp.left, arr, len + 1);
        numPaths(temp.right, arr, len + 1);
    }
    
    static void print(int arr[], int len){
        for(int k = 0; k <= len; k++) System.out.print(arr[k] + " ");
        System.out.println();
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