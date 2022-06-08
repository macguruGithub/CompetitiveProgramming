package com.practice.rajaguru.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainsDuplicate_217 {
    public static void main(String[] args) {
        boolean result = new ContainsDuplicate_217().containsDuplicate(new int[]{1,1});
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
        
        return Stream.of(nums).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toSet()).size()!=nums.length;
    }
}
