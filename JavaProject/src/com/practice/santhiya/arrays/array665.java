package com.practice.santhiya.arrays;

public class array665 {

        public static void main(String args[]) {
            int[] nums= new int[]{3,5,1};
            boolean a=nondec(nums);
            System.out.println(a);
        }

        public static boolean nondec(int[] nums){
            //int[] nums= new int[]{5,3,2,1};
            boolean b= true;
            for(int i=1,err=0;i<nums.length;i++){
                // System.out.println(nums[i]);
                if(nums[i]<nums[i-1]){
                    // first element should be less than than the second element.if so then also check for the next to next element to be greater and next element to be []
                    if(err++ >1 || (i > 1 && i < nums.length - 1 && nums[i-2] > nums[i] && nums[i+1] < nums[i-1]))
                        System.out.println("loop");
                    //break;
                    b = false;
                    break;
                }

            }
            return b;

        }

    }

