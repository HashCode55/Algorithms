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
//Simple divide and conquer approach
public class LRA {
    static int max = -1;
    public static void main(String args[]){
        int arr[] = {6, 2, 5, 4, 5, 1, 6};
        max = findMaxRect(arr, 0, 6);
        System.out.println(max);
    }
    
    public static int findMaxRect(int arr[], int i, int j){
        if(i <= j){
            int k = findMin(arr, i, j);
            return max(findMaxRect(arr, i, k - 1), findMaxRect(arr, k + 1, j), arr[k] * (j-i+1));
        }
        return 0;
    }
    
    public static int max(int i, int j, int k){
        int max = -1;
        if(i > j)
            max = i;
        else max = j;
        if(k > max) max = k;
        return max;
    }
    
  
    
    public static int findMin(int arr[], int i, int j){
        int min = Integer.MAX_VALUE;
        int in = 0;
        for(int k = i; k <= j; k++) { if (arr[k] < min) {min = arr[k]; in = k;}}
        return in;
    }
}
