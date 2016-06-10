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
public class Oddnum {
    public static void main(String args[]){
        int arr[] = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2}, xor = arr[0];
        for(int i = 1; i < arr.length; i++) xor ^= arr[i];
        System.out.println(xor);
    }
}
