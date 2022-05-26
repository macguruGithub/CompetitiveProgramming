package com.practice.rajaguru.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
    {16,17,18,19,20},{21,22,23,24,25}
    };
    spiralOrder(matrix).forEach(element -> System.out.print(element+" "));

    }

    static List<Integer> spiralOrder(int[][] matrix) {
        int r_s = 0, c_s = 0, r = 0, c = 0, r_e = matrix.length - 1, c_e = matrix[0].length - 1;
        String play = matrix[0].length > 1 ? "horizontal_forward" : "vertical_down";
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output.add(matrix[r][c]);
                if (play.equals("horizontal_forward") && c < c_e) {
                    c++;
                    if (c == c_e) {
                        play = "vertical_down";
                        c_e--;
                        if(i==0) r_s++;
                        continue;
                    }
                } else if (play.equals("vertical_down") && r < r_e) {
                    r++;
                    if (r == r_e) {
                        play = "horizontal_backward";
                        r_e--;
                        continue;
                    }
                } else if (play.equals("horizontal_backward") && c > c_s) {
                    c--;
                    if (c == c_s) {
                        play = "vertical_up";
                        c_s++;
                        continue;
                    }
                } else if (play.equals("vertical_up") && r > r_s) {
                    r--;
                    if (r == r_s) {
                        play = "horizontal_forward";
                        r_s++;
                    }
                }
            }
        }
        return output;
    }
}
