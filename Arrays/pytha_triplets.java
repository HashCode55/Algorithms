/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Arrays;

/**
 *
 * @author mehul
 */
//Naive solution is to apply 3 loops which'll lead to O(n^3) complexity.
//Better approach is as under... O(n^2)
public class pytha_triplets {
    public static void main(String args[]){
        int arr[] = {3, 1, 4, 6, 5};
        int squared[] = new int[arr.length]; 
        for(int i = 0; i < squared.length; i++){
            squared[i] = arr[i] * arr[i];
        }
        Arrays.sort(squared);
        if(triplet(squared))
            System.out.println("Yes it is possible");
        else
            System.out.println("No it is not possible");
    }
    
    static boolean triplet(int squared[]){
        int len = squared.length;
        for(int i = len - 1; i >= 2; i--){
            int num = squared[i];
            int j = 0, k = i - 1;
            while(j < k){
                if(squared[j] + squared[k] == num)
                    return true;
                else if(squared[j] + squared[k] < num)
                    j++;
                else
                    k--;
            }
        }
        return false;
    }
}