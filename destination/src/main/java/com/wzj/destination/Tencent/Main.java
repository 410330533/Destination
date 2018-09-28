package com.wzj.destination.Tencent;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] questions = new int[t][3];
        for(int i = 0; i < t; i++){
            questions[i][0] = in.nextInt();
            questions[i][1] = in.nextInt();
            questions[i][2] = in.nextInt();
        }

        for(int i = 0; i < t; i++){
            HashSet<Integer> set = new HashSet<>();
            int a = questions[i][0], b = questions[i][1], c = questions[i][2];
            int remain = a % b;
            while(remain != c ){
                set.add(remain);
                a += a;
                remain = a % b;
            }
            if(remain == c){
                System.out.println(YES);

            }else {
                System.out.println(NO);
            }

        }



    }
}
