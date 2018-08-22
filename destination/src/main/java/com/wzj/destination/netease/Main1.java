package com.wzj.destination.netease;

/**
 * Created by WZJ on 2018/8/11.
 */

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] interest = new int[n], weak = new int[n];
        for(int i = 0; i < n; i++){
            interest[i] = sc.nextInt();
        }
        int val = 0;
        for(int i = 0; i < n; i++){
            weak[i] = sc.nextInt();
            if(weak[i] == 1) val += interest[i];

        }

        int maxInterest = 0;

        for(int i = 0; i < n; i++){
            if(weak[i] == 0) {
                int temp = 0;
                for(int j = 0; j < k; j++){
                    if(i + j >= n){
                        if(temp > maxInterest){
                            val -= maxInterest;
                            val += temp;
                            maxInterest = temp;
                        }
                        System.out.println(val);
                        return;
                    }else{
                        if(weak[i + j] != 1){
                            temp += interest[i + j];
                        }
                    }


                }
                if(temp > maxInterest){
                    val -= maxInterest;
                    val += temp;
                    maxInterest = temp;
                }
            }
        }
        System.out.println(val);
    }
}
