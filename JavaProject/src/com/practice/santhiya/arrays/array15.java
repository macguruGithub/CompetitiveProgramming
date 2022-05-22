package com.practice.santhiya.arrays;
import java.util.*;




/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

         Notice that the solution set must not contain duplicate triplets.*/
public class array15 {

    public static void main(String[] args){

        int[] nums = new int[]{0,0,0};

        List<List<Integer>> a = threeSum(nums);
        System.out.println(a);

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  output =new LinkedList();
        int len= nums.length;
        int tempSum;
        if(len< 3){
            return output;
        }
        Arrays.sort(nums);
        // Find triplets and then sum up to zero
        // No duplicates allowed meaning no same triplet can come again
        for(int i=0;i<nums.length-2 ;i++){ // since we are looking for the pair of elements after that current element
            if(i!=0 && nums[i]==nums[i-1]){// If is 0 or it is equal to next element
                continue;// if we get the first element of the array again for next iteration then we dont want to loop through.
            }
            int l=i+1;
            int r=len-1;
            while(l <r){
                tempSum= nums[i]+nums[l]+nums[r];
                if (tempSum ==0){
                    List<Integer> templist = new ArrayList();
                    templist.add(nums[i]);
                    templist.add(nums[l]);
                    templist.add(nums[r]);
                    output.add(templist);
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(l<r-1 && nums[r] == nums[r+1]){
                        r--;
                    }
                }
                else if(tempSum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return output;
    }
}
