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
 //xoring algorithm makes it easy to find the missing element in the array.... Expand
//on notebook to check how the algo works!
public class sde1 {
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 5, 6, 7};
        int arr2[] = {1, 3, 5, 6, 7};
        
        int x1 = arr[0];
        for(int i = 1; i < arr.length; i++) x1 = x1 ^ arr[1];
        int x2 = arr2[0];
        for(int i =0; i < arr.length; i++)  x2 = x2 ^ arr[1];  
        System.out.println(x1^x2);
    }
}
