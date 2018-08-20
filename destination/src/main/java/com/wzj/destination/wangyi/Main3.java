package com.wzj.destination.wangyi;

/**
 * Created by WZJ on 2018/8/11.
 */

import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[4 * n][4];

        for(int i = 0; i < 4 * n; i++){
            for(int j = 0; j < 4; j++){
                num[i][j] = sc.nextInt();
            }
        }



    }
}
