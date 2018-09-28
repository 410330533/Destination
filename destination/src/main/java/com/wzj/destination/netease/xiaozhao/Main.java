package com.wzj.destination.netease.xiaozhao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] capacity = new int[n];
        int[] remain = new int[n];
        for (int i = 0; i < n; i++){
            capacity[i] = in.nextInt();
        }

        for(int i = 0; i < m; i++){
            int instructions = in.nextInt();
            if(instructions == 2){
                int level = in.nextInt();
                int volume = in.nextInt();
                for(int j = level - 1; j >= 0 && volume > 0; j--){
                    if(remain[j] < capacity[j]){
                        int val = capacity[j] - remain[j];
                        if(volume >= val){
                            remain[j] = capacity[j];
                        }else{
                            remain[j] += volume;
                        }
                        volume -= val;
                    }
                }
            }else{
                System.out.println(remain[in.nextInt() - 1]);
            }
        }
    }
}
