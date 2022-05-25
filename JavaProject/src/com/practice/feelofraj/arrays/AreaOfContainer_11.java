package com.practice.feelofraj.arrays;

public class AreaOfContainer_11 {
    public static void main(String[] args) {
        AreaOfContainer_11 s = new AreaOfContainer_11();
        // {2,3,4,5,18,17,6}

        int[] height = { 1, 1000, 1000, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(s.maxArea(height));
    }

    public int maxArea(int[] height) {
        int area = 0;
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            /*
             * l=height[i]<height[j]?height[i]:height[j];
             * b=j-i;
             * area=l*b;
             */
            area = Math.min(height[i], height[j]) * (j - i);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j])
                i++;
            else
                j--;

        }
        return maxArea;
    }
}
