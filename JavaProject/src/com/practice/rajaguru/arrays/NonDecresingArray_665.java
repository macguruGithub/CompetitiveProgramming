package com.practice.rajaguru.arrays;

public class NonDecresingArray_665 {
    public static void main(String[] args) {
        System.out.println(new NonDecresingArray_665().checkPossibility(new int[] { 3, 4, 2, 3 }));
    }

    public boolean checkPossibility(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    if (c > 0)
                        return false;
                    nums[i] = nums[i + 1];
                    c++;
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    if (c > 0)
                        return false;
                    int temp = nums[i + 1];
                    if (nums[i - 1] > temp) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = temp;
                    }
                    c++;
                }
            }
        }
        return true;
    }

}
