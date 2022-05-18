package com.practice.rajaguru.arrays;

public class LongestSubStringWithoutRepeatChar_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int l = s.length() > 0 ? 1 : 0;
        String[] sArr = s.split("");
        for (int i = 0; i < s.length() - 1; i++) {
            String subStr = sArr[i];
            for (int j = i + 1; j < s.length(); j++) {
                if (subStr.contains(sArr[j])) {
                    break;
                }
                subStr = subStr + sArr[j];
                if (subStr.length() > l)
                    l = subStr.length();
            }
        }
        return l;

    }
}
