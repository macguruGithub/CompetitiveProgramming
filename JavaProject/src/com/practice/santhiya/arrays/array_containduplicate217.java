package com.practice.santhiya.arrays;

import java.util.*;

public class array_containduplicate217{

    public static void main(String args[]) {
        int[] input = new int[]{1,2,3,1};
        boolean output = containsDuplicate(input);
        System.out.println(output);
    }

    // Not efficient way
    public static boolean containsDuplicate(int[] nums) {
        boolean output=false;
        List<Integer> temp = new ArrayList<>();
        for(int val: nums){
           if(temp.contains(nums[val])){
               output=true;
               break;
           }
          else {
              temp.add(nums[val]);
              output=false;
           }
        }
        return output;
    }

    //Efficient way -- add a set and then loop it
    public boolean containsDuplicateEff(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            if(set.contains(val)) return true;
            set.add(val);
        }
        return false;
    }
}
