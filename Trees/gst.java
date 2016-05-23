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
//the trick is to keep track of reverse inorder traversal in the recursion 
//and BOOM! you'll get the solution!
public class GST {
    public static TreeNode root;
    static int sum = 0;
    public static void main(String args[]){
        root = new TreeNode(11);
        root.left = new TreeNode(2);
        root.right = new TreeNode(29);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(40);
        root.right.right.left = new TreeNode(35);
        TreeNode temp = root;
        
        inOrder(root);
        System.out.println();
        greaterSumTree(root);
        inOrder(root);
    }
    
    public static void greaterSumTree(TreeNode temp){
        if(temp!=null){
            greaterSumTree(temp.right);
            
            int tempo = sum;
            
            sum = sum + temp.data;
            temp.data = tempo;
            greaterSumTree(temp.left);
        }
    }
    
    public static void inOrder(TreeNode temp){
        if(temp != null){
            inOrder(temp.left);
            System.out.print(temp.data + " ");
            inOrder(temp.right);
        }
    }
}
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }    
}
