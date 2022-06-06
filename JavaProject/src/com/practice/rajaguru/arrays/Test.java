package com.practice.rajaguru.arrays;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
    double value = 1.1;
    
    // value = value - value % 1;
    // System.out.println(value);
        int a = (int)1.132423423;
        System.out.println(a);


    }

    

    

    //print sum of n natural numbers
    void sumOfnNatural(int n, Integer sum){
        if(n == 0){
            System.out.println(sum);
            return ;
        }
        
        sum= sum+n;
        sumOfnNatural(n-1, sum);
    }

    void printTill_N(int s, int e){
        if(s >= e+1){
            System.out.println("\nexec over ...");
            return;
        }
        System.out.print("b=>"+s+" ");
        printTill_N(s+1, e);
        System.out.print("a=>"+s+" ");

    }

    void fac(int n, int mul){
        if(n == 0) {
            System.out.println(mul);
            return ;
        }
        mul=mul*n;
        fac(n-1,mul);

    }

    int getNthfibnacci(int n){
        if(n == 1){
            return 0;
        }else if(n == 2 ){
            return 1;
        }else if(n > 2){
            return finRec(n-2,0,1);
        }else{
            return n;
        }
        
    }

    int finRec(int n, int a, int b){
        if(n == 0 ) return b;
        int c = a+b;
        a=b;
        b=c;

        int fin = finRec(--n,a,b);
        return fin;

    }

    int XpowN(int x, int n, int result){
        if(n == 0) return 1;
        if(n == 1) return result;
        result  = result * x;
        return XpowN(x, n-1, result);
    }
}