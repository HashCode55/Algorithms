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
 //single pass bubble sort
public class sde1 {
    public static void main(String args[]){
        int arr[] = {1, 4, 3, 2};
        
        for(int i = 1; i < arr.length; i++){
            if(i % 2 == 0){
                if(arr[i] < arr[i - 1]) continue;
                else swap(arr, i, i - 1);
            }
            else{
                if(arr[i] > arr[i - 1]) continue;
                else swap(arr, i, i - 1);
            }
        }
        
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    }
    
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
