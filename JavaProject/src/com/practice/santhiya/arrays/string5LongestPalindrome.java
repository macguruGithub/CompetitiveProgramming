package com.practice.santhiya.arrays;



//Dynamic programmingTime O(n^2) Space O(n^2)
public class string5LongestPalindrome {

    public static void main(String[] args) {

        String result= longpalindrome("banana");
        System.out.println(result);

    }

    public static String longpalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        int maxLength = 1;
        boolean[][] dp = new boolean[len][len];
        String longestSub = null;
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        longestSub = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestSub;
    }
}