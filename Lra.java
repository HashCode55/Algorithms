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
        findMaxRect(arr, 0, 6);
    }
    
    public static void findMaxRect(int arr[], int i, int j){
        if(i <= j){
            int k = findMin(arr, i, j);
            findMaxRect(arr, i, k - 1);
            findMaxRect(arr, k + 1, j);
            findMaxArea(arr, i, k, j);
        }
    }
    
    public static void findMaxArea(int arr[], int i, int k, int j){
        
    }
    
    public static int findMin(int arr[], int i, int j){
        int min = Integer.MAX_VALUE;
        int in = 0;
        for(int k = i; k < j; k++) { if (arr[i] < min) min = arr[i]; in = i;}
        return in;
    }
}
