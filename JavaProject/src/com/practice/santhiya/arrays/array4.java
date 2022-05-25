package com.practice.santhiya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class array4 {


    public static void main(String args[]) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target =0;
        List<List<Integer>> a = fourSum(nums,target);
        System.out.println(a);

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> output = new LinkedList();
        int len = nums.length;
        int tempSum;
        if (len < 3) {
            return output;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {// If is 0 or it is equal to next element
                continue;// if we get the first element of the array again for next iteration then we dont want to loop through.
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else {
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        output.add(t);

                        k++;
                        l--;

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }

            }

        }
        return output;
    }
}
