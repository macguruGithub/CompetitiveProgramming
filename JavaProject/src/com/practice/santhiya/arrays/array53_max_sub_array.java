package com.practice.santhiya.arrays;

public class array53_max_sub_array {

    public static void main(String args[]) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int a = maxSubArray(nums);
        System.out.println(a);
    }
    public static int maxSubArray(int[] nums){
        int max_val= Integer.MIN_VALUE;
        int cur=0;
        for(int val:nums){
            if(cur<0)
                cur=0;
                cur+=val;
                max_val=Math.max(max_val,cur);
        }
        return max_val;
    }
}
