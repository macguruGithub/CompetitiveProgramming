package com.practice.santhiya.arrays;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store.

        Notice that you may not slant the container.*/



import java.util.concurrent.TimeUnit;
public class array11 {

    //rectangle -- > height * width

    public static void main(String args[]) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        long startTime = System.nanoTime();
        int a = maxArea(height);
        System.out.println(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        long convert = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        System.out.println("maxarea"+duration +"ns and "+convert+"seconds");
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        long startTime2 = System.nanoTime();
        int b = effIte(heights);
        System.out.println(b);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        long convert2 = TimeUnit.SECONDS.convert(duration2, TimeUnit.NANOSECONDS);
        System.out.println("maxarea"+duration2 +"ns and "+convert2+"seconds");
    }
// Brute Force
    public static int maxArea(int[] height) {
        int ans = 0; // default value

        for (int l = 0; l < height.length; l++) {// length element
            for (int w = l + 1; w < height.length; w++) { // width element
                System.out.println("l"+l);
                System.out.println("w"+w);
                System.out.println("w-l"+ (w-l));
                int area = (w - l) * Math.min(height[l], height[w]);  // find the area of rectangle that we can build
                ans = Math.max(ans, area); // ans will always have the maximum area value.
            }
        }
        return ans;// More iteration to get the result.
    }

//Linear and efficient
    public static int effIte(int[] heights) {
        int ans =0;

        int l= 0;
        int w= heights.length -1;
         while (l < w){
             int area = (w - l) * Math.min(heights[l], heights[w]);  // find the area of rectangle that we can build
             ans = Math.max(ans, area); // ans will always have the maximum area value

             if(heights[l]<heights[w]){
                 l=l+1;
             }
             else{
                 w=w-1;
             }
         }
        return ans;
    }


}