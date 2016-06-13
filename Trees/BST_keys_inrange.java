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
//simple recursion....
public class BST_keys_inrange {
    static Node root;
    static int mod = 0;

    public static void main(String args[]){
        gfg tree = new gfg();
        int k1 = 10, k2 = 25;
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);

        tree.Print(root, k1, k2);
    }

    static void Print(Node root, int k1, int k2){
        if(root != null)
            {if(root.data > k1)
                Print(root.left, k1, k2);
                if(root.data > k1 && root.data <= k2)
                    System.out.print(root.data + " ");
                if(root.data < k2)
                    Print(root.right, k1, k2);
            }
        }
}

class Node{
        int data;
        Node left, right;
        public Node(int d){
            this.data = d;
            left = null;
            right = null;
        }
}