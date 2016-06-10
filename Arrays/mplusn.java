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
public class mplusn {
    public static void main(String args[]){
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        moveToEnd(mPlusN);
        int N[] = {5, 7, 9, 25};
        int i = N.length, j = 0, k = 0;
        for( ; j < mPlusN.length; ){
            if(i < mPlusN.length && mPlusN[i] < N[k]){
                mPlusN[j] = mPlusN[i];
                i++;
                j++;
            }
            else{
                mPlusN[j] = N[k];
                k++;
                j++;
            }
        }
        for(int f = 0; f < mPlusN.length; f++) System.out.print(mPlusN[f] + " ");
    }
    
    static void moveToEnd(int arr[]){
        int j = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] != -1){
                arr[j] = arr[i];
                j--;
            }
        }
        for(int f = 0; f < arr.length; f++) System.out.print(arr[f] + " ");
        System.out.println();
    }
}
