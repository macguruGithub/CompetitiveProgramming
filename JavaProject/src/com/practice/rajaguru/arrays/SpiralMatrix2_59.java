package com.practice.rajaguru.arrays;

public class SpiralMatrix2_59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix =  spiralOrder2(n);
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    static int[][] spiralOrder2(int n) {
        int r_s = 0, c_s = 0, r = 0, c = 0, r_e =n - 1, c_e = n - 1;
        String play = n > 1 ? "horizontal_forward" : "vertical_down";
        int[][] matrix = new int[n][n];
        int value = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[r][c]=++value;
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
        return matrix;
    }
}
