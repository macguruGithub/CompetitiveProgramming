package com.practise.rajaguru.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,7,11,15};
		System.out.println(Arrays.toString(twoSumUsingArray(arr,9)));

	}
	
	//using array
	public static int[] twoSumUsingArray(int[] arr, int target) {
        int[] output = new int[2];
        for(int i=0; i<arr.length-1 ;i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]+arr[j]==target) {
                    output[0]=i;
                    output[1]=j;
					i=-1;
					break;
				}
			}
			if(i==-1) {
				break;
			}
		}
        return output;
        
    }
	
	//using HashMap
		public static int[] twoSumUsingHashMap(int[] nums, int target) {
			HashMap<Integer, Integer> map = new HashMap<>();
	        int count = 0;
	        for(int i=0; i<nums.length; i++){
	            System.out.println(++count);
	            int compli = target-nums[i];
	            
	            if(!map.containsKey(compli)){
	                map.put(nums[i], i);
	            }
	            
	            else{
	                return new int[] {map.get(compli),i};
	            }
	            
	        }
	        return new int[] {0,0};
		}
		

}
