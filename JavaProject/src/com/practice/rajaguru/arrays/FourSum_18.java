package com.practice.rajaguru.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_18 {
    public static void main(String[] args) {
        threeSum();
    }

    //two pointer approach - perfect working condition
    static void threeSum(){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        Set<List<Integer>> fourLets = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                int s = j+1;
                int e = nums.length-1;
                while(s<e){
                    int sum=nums[i]+nums[j]+nums[s]+nums[e];
                    if(sum == target){
                        int[] arr = {nums[i],nums[j],nums[s],nums[e]};
                        Arrays.sort(arr);
                        fourLets.add(List.of(arr[0],arr[1],arr[2],arr[3]));
                    }
                    if(sum>target) e--; else s++;
                }
            }
        }
        fourLets.forEach(triple -> {
            System.out.println();
            triple.forEach(System.out::print);
        });
    }
}
