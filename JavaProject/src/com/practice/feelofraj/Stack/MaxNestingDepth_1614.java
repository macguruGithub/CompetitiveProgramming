package com.practice.feelofraj.Stack;

public class MaxNestingDepth_1614 {
    public static void main(String[] args) {
        MaxNestingDepth_1614 m=new MaxNestingDepth_1614();
       System.out.println(m.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
    public int maxDepth(String s) {
        int count=0,out=0;
         for(char ar: s.toCharArray()){
             if(ar=='(')
                 count++;
             else if(ar==')'){
                 if(out<count)out=count;
                 count--; 
             }
                
         }return out;
     }
}
