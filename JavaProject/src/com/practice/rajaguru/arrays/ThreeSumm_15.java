package com.practice.rajaguru.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//working but slow
public class ThreeSumm_15 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> triples = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] tt = { nums[i], nums[j], nums[k] };
                        if (triples.stream().filter(t -> {
                            String a = tt[0] + "";
                            String b = tt[1] + "";
                            String c = tt[2] + "";
                            for (int t1 = 0; t1 < t.size(); t1++) {
                                if (!a.equals("checked") && t.get(t1) == Integer.valueOf(a)) {
                                    a = "checked";
                                } else if (!b.equals("checked") && t.get(t1) == Integer.valueOf(b)) {
                                    b = "checked";
                                } else if (!c.equals("checked") && t.get(t1) == Integer.valueOf(c)) {
                                    c = "checked";
                                } else {
                                    return false;
                                }
                            }
                            return true;
                        }).collect(Collectors.toList()).size() == 0) {
                            List<Integer> triple = new ArrayList<>();
                            triple.add(nums[i]);
                            triple.add(nums[j]);
                            triple.add(nums[k]);
                            triples.add(triple);
                        }
                    }
                }
            }
        }
        triples.forEach(triple -> {
            System.out.println();
            triple.forEach(System.out::print);
        });
    }
}

/*abstract




*/