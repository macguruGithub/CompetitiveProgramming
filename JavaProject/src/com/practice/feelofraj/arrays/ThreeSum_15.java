package com.practice.feelofraj.arrays;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {
        ThreeSum_15 t = new ThreeSum_15();
        // -1,0,1,2,-1,-4
        // 0,0,0,0 
        //-2, 0, 1, 1, 2 
        // -2,-3,0,0,-2
        int[] num = {-2, 0, 1, 1, 2};
        t.threeSum(num);
    }

    public <T> List<List<Integer>> threeSum(int[] nums) throws NullPointerException {
        List<List<Integer>> totalList = new ArrayList<List<Integer>>();
        LinkedHashSet<Integer> numb = new LinkedHashSet<>();
        for (int i : nums)
            numb.add(i);
        // System.out.println(numb.toString());
        Arrays.sort(nums);
       
        for(int i=0;i<nums.length-2;i++){
            int j = i+1, k = nums.length - 1;
            while (j < k) {
                int sum=nums[i] + nums[j] + nums[k];
                if (sum== 0) {
                    List<Integer> nList = new ArrayList<Integer>();
                    nList.add(nums[i]);
                    nList.add(nums[j]);
                    nList.add(nums[k]);
                    Collections.sort(nList);
                    if (!totalList.contains(nList)) {
                        totalList.add(nList);
                        System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
                    }
                    
                }
                if (sum > 0)
                k--;
                else {
                    j++;
                }
            }
        }
        return totalList;
    }

    
}
