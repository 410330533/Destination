package com.wzj.destination.netease;

/**
 * Created by WZJ on 2018/8/11.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] num = new int[m];
        for(int i = 0; i < m; i++){
            num[i] = sc.nextInt();
        }

        int[] count = new int[n];
        for(int i : num){
            count[i-1]++;
        }
        int res = 0;
        for(int j = 0; j < m; j++){
            for (int i = 0; i < n; i++){
                if(count[i] > 0){
                    count[i]--;
                }else{
                    System.out.println(res);
                    return;
                }
            }
            res++;
        }

    }
}
