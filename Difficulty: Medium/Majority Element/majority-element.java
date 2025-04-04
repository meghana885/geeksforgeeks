//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int count =0;
        int candidate=-1;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                candidate=arr[i];
                count=1;
            }
            else if(arr[i]==candidate){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==candidate){
                count++;
            }
        }
        if(count>arr.length/2){
            return candidate;
        }
        else{
            return -1;
        }
    }
}