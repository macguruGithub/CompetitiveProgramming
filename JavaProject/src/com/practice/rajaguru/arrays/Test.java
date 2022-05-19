package com.practice.rajaguru.arrays;

public class Test {
    public static void main(String[] args) {
        int n=5;
        int fib = new Test().getNthfibnacci(7);
        int xPowNresult = new Test().XpowN(2, 4, 2);
        System.out.println(xPowNresult);
        

        // System.out.println(n);
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