
package com.practice.santhiya.arrays;

public class string3 {

    public static void main(String[] args){

        String s ="abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }


    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int res = 0;

        for(int i = 0; i < n; i++)
        {

            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++)
            {
                if (visited[s.charAt(j)] == true) {
                    System.out.println(visited[i]);
                    break;
                }
                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
            visited[s.charAt(i)] = false;
        }
        return res;

    }
}


// Brute Force approach
// Sliding Window approach

