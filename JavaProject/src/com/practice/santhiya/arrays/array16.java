package com.practice.santhiya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array16 {

    public static void main(String args[]) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        //  boolean a=nondec(nums);
        int a = closetar(nums, target);
        System.out.println(a);
    }

    public static int closetar(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int tempSum = 0;
        int result = nums[0] + nums[1] + nums[len-1];;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                tempSum = nums[i] + nums[l] + nums[r];
                if (tempSum <= target) {
                    l++;
                } else {
                    r--;
                }
                if (Math.abs(result - target) > Math.abs(tempSum - target)) {
                    result = tempSum;
                }

            }
        }
        return result;

    }
}