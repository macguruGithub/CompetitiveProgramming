package com.practice.rajaguru.arrays;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int output = threeSumClosest(new int[]{-1,2,1,-4},1);
        System.out.println(output);
    }


    public static int threeSumClosest(int[] arr, int target) {
        int diff = Integer.MAX_VALUE;
        int output = 0;
        if(arr.length < 4) return arr[0]+arr[1]+arr[2];
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length-1; i++) {
            int f = i;
            int s = i+1;
            int e = arr.length-1;
            while(s<e){
                if (arr[f]+arr[s]+arr[e] == target) return target;
                if(diff>Math.abs(target - (arr[f]+arr[s]+arr[e]))
                  ){
                    output=arr[f]+arr[s]+arr[e];
                    diff = Math.abs(target-(arr[f]+arr[s]+arr[e]));    
                }
                if(arr[f]+arr[s]+arr[e]>target)e--;else s++;
            }
        }
        return output;
    }
    
}
