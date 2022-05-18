package com.practice.rajaguru.arrays;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int max = maxAreaCal(arr,0,arr.length-1,0);
        System.out.print(max);
    }
    
    //iterating using recursion
    static int maxAreaCal(int[] arr, int s, int e, int max){
        if(s > e){
            return max;
        }
        int result = Math.min(arr[s], arr[e])*(e-s);
        if(arr[s] < arr[e]) s++; else  e--;
        return maxAreaCal(arr, s, e, Math.max(max, result));
        
    }
}


