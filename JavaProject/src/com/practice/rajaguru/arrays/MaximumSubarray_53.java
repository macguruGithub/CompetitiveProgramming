package com.practice.rajaguru.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] arr = new int[] { -3,1,-2,2 };
        int result = new MaximumSubarray_53().maxSubArray(arr);
        System.out.println(result);

    }

    public int maxSubArray(int[] nums) {

        int[] addUntilMinus = { 0 };
        return Stream.of(nums).flatMapToInt(Arrays::stream).boxed().reduce(Integer.MIN_VALUE, (prev, curr) -> {
            if (addUntilMinus[0] < 0)
                addUntilMinus[0] = 0;
            addUntilMinus[0] += curr;
            return Math.max(prev, addUntilMinus[0]);
        });

    }
}
