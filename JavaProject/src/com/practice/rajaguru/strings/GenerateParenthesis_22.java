package com.practice.rajaguru.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        List<String> result = new ArrayList<String>();
        int n = 3;
        new GenerateParenthesis_22().generate("(", 1, 0, n, result);
        System.out.println(result);

    }

    private void generate(String str, int open, int close, int n, List<String> result)
    {
        if(str.length() == 2 * n)
        {
            result.add(str);
            return;
        }
        if(open < n)
            generate(str + "(", open + 1, close, n, result);
        if(close < open)
            generate(str + ")", open, close + 1, n, result);
    }
}
