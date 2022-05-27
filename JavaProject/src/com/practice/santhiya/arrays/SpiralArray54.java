package com.practice.santhiya.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray54 {

    public static void main(String[] args){

        int[][] matrix  = new int[][]{{1,    2,   3},
                {5,    6,   7}};
        int len=matrix.length;
        System.out.println(len);
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length ==0){
            return result;
        }
        int rowStart=0;
        int rowEnds=matrix.length-1;// 4 element then length is 4 but the row starts with 0,1,2,3
        int colStart=0;
        int colEnds= matrix[0].length-1;

        while(rowStart<=rowEnds && colStart<=colEnds){

            for(int i=colStart;i<=colEnds;i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            for(int j=rowStart;j<=rowEnds;j++){
                result.add(matrix[j][colEnds]);
            }
            colEnds--;

            if(rowStart<=rowEnds){

                for(int i=colEnds;i>=colStart;i--){
                    result.add(matrix[rowEnds][i]);
                }
            }
            rowEnds--;

            if(colStart<=colEnds){
                for(int i=rowEnds;i>=rowStart;i--){
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }

        }

        return result;
    }
}
