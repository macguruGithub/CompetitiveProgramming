package com.practice.santhiya.arrays;
import java.util.HashMap;
import java.util.Map;

public class string12roman {

    public static String intToRoman(int num) {
        String romans[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int value[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int seqSize = romans.length;
        int idx = seqSize - 1;
        String ans = "";
        while(num>0){
            while(value[idx]<=num){
                ans += romans[idx];
                num -= value[idx];
            }
            idx--;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(intToRoman(8));
    }

}
