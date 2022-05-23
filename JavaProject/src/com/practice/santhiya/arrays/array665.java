package com.practice.santhiya.arrays;

public class array665 {

        public static void main(String args[]) {
            int[] nums= new int[]{4,2,3};
          //  boolean a=nondec(nums);
            boolean a= nondecarray(nums);
            System.out.println(a);
        }

        public static boolean nondec(int[] nums){
            //int[] nums= new int[]{5,3,2,1};
            boolean b= true;

            for(int i=1,err=0;i<nums.length;i++){
                // System.out.println(nums[i]);
                if(nums[i]<nums[i-1]){
                    // first element should be less than than the second element.if so then also check for the next to next element to be greater and next element to be []
                    if(err++ >2 || (i > 1 && i < nums.length - 1 && nums[i-2] > nums[i] && nums[i+1] < nums[i-1])){
                        b = false;
                        break;
                    }
                    System.out.println("loop");
                    //break;
                    }

                }
            return b;

        }

        // Working for all scenarios.16
        public static boolean nondecarray(int[] nums){
            int cnt = 0;                                                                    //the number of changes
            for(int i = 1; i < nums.length && cnt<=1 ; i++){
                if(nums[i-1] > nums[i]){
                    cnt++;
                    if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                    else nums[i] = nums[i-1];                                                //have to modify nums[i]
                }
            }
            return cnt<=1;

        }

    }

