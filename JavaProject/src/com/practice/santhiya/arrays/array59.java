package com.practice.santhiya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array59 {

    public static void main(String[] args){

        int n= 3;
        int[][] result = spiralOrder(n);
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] spiralOrder(int n) {
        int[][] result = new int[n][n];
        System.out.println(result);
        if(n ==0){
            return result;
        }
        int rowStart=0;
        int rowEnds=n-1;// 4 element then length is 4 but the row starts with 0,1,2,3
        int colStart=0;
        int colEnds= n-1;

        int count=1;
        while(rowStart<=rowEnds && colStart<=colEnds) {
            for (int i = colStart; i <= colEnds; i++) {
                result[rowStart][i] = count++;
            }

            rowStart++;

            for (int j = rowStart; j <= rowEnds; j++) {
                result[j][colEnds] = count++;
            }
            colEnds--;

            if (rowStart <= rowEnds) {

                for (int i = colEnds; i >= colStart; i--) {
                    result[rowEnds][i] = count++;
                }
            }
            rowEnds--;

            if (colStart <= colEnds) {
                for (int i = rowEnds; i >= rowStart; i--) {
                    result[i][colStart] = count++;
                }
                colStart++;
            }
           // System.out.println(result);
        }

        return result;
    }


}
