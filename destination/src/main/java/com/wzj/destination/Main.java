package com.wzj.destination;

import java.util.Scanner;

public class Main {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][m];
        int max = 0, startX = 0, startY = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //System.out.println(num[i][j]);
                num[i][j] = sc.nextInt();
                if(num[i][j] > max){
                    max = num[i][j];
                    startX = i;
                    startY = j;
                }
            }
        }
        //ans
        int[][] visited = new int[n][m];
        solve(num, startX, startY, 0, visited);


        System.out.println(res);
    }
    public static void solve(int[][] num, int i, int j, int count, int[][] v){
        //if(i < 0 || j < 0 || i >= num.length || j >= num[0].length) return ans;
        System.out.println(num[i][j]+" "+count);
        if(v[i][j] == 1){
            return;
        }
        if(num[i][j] == 1){
            res = Math.max(res, count + 1);
        }
        v[i][j] = 1;
        if(i - 1 >= 0 && num[i - 1][j] < num[i][j])
            solve(num, i - 1, j, count + 1, v);
        if(i + 1 < num.length && num[i + 1][j] < num[i][j])
            solve(num, i + 1, j, count + 1, v);
        if(j - 1 >= 0 && num[i][j - 1] < num[i][j])
            solve(num, i, j - 1, count + 1, v);
        if(j + 1 < num[0].length && num[i][j + 1] < num[i][j])
            solve(num, i, j + 1, count + 1, v);
        v[i][j] = 0;


    }
}