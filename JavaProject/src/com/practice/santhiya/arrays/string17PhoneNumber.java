package com.practice.santhiya.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class string17PhoneNumber {
   private static  List<String> output = new ArrayList<String>();

    public static void main(String args[]){

        List<String> output = new ArrayList<String>();
        String input="";
        output=letterCombination(input);
        System.out.println(output);

    }

    public  static List<String> letterCombination(String input){
        if(input.isEmpty()|| input.isBlank()){
            return output;
        }
        if (input.length() != 0) {
            backtrack("", input);
        }
        return output;
    }

        public static void backtrack(String combination, String next_digits) {

            Map<String, String> phone = new HashMap<String, String>() {{
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }};
            if (next_digits.length() == 0) {
                output.add(combination);
            }
            else {
                String digit = next_digits.substring(0, 1);
                String letters = phone.get(digit);

                for (int i = 0; i < letters.length(); i++) {
                    String letter = letters.substring(i, i + 1);
                    backtrack(combination + letter, next_digits.substring(1));
                }
            }
        }
}
