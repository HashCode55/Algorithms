/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehul
 */
public class DynamicP {
    public static void main(String args[]){
        String s = "abcdgh";
        String s2 = "aedfhr";
        char sarr[] = s.toCharArray();
        char s2arr[] = s2.toCharArray();
        //int k = findLongest(sarr, s2arr, sarr.length - 1, s2arr.length - 1);
        int k = findLongestdp(sarr, s2arr);
        System.out.println(num(3, 6));
    }    
    public static int findLongest(char arr[], char arr2[], int i, int j){
        if(i < 0 || j < 0)
            return 0;
        if(arr[i] == arr2[j])
            return 1 + findLongest(arr, arr2, i-1, j-1);
        return Math.max(findLongest(arr, arr2, i-1, j), findLongest(arr, arr2, i, j-1));
    }
    
    public static int findLongestdp(char arr[], char arr2[]){
        int l1 = arr.length;
        int l2 = arr2.length;
        
        int dp[][] = new int[l1+1][l2+1];
        for(int i = 0; i <= l1; i++){
            for(int j = 0; j <= l2; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else{
                    if(arr[i-1] == arr2[j-1])
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[l1][l2];
    }
    //important step 
    public static int num(int num, int sum){
        int ss = 0;
        for(int i = 1; i <= 9; i++){
            ss += getNumbers(num - 1, sum - i);
        }
        return ss;
    }
    public static int getNumbers(int num, int sum){
        if(sum < 0 || num < 0)
            return 0;
        if(num == 0 && sum!= 0)
            return 0;
       
        if(sum == 0 && num == 0){            
            return 1;
        }
        int res = 0;
        for(int i = 0; i <= 9; i++){
            res += getNumbers(num - 1, sum - i);
        }            
        return res;
    }
    
}


