package com.wzj.destination.baidu;

public class RotateMatrix {
    //matrix[n - j - 1][i]顺时针旋转90度的位置为matrix[i][j]
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int round = 0; round < n / 2; round++){
            for (int i = round; i < n - round - 1; i++){
                int temp = matrix[round][i];
                matrix[round][i] = matrix[n - i - 1][round];
                matrix[n - i - 1][round] = matrix[n - round - 1][n - i - 1];
                matrix[n - round - 1][n - i - 1] = matrix[i][n - round - 1];
                matrix[i][n - round - 1] = temp;
            }
        }
    }
}
