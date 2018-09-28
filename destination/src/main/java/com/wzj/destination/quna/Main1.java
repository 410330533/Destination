package com.wzj.destination.quna;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(m > 0){
            int cur = k;
            for(; check(cur, n) && cur > 0; cur--){
                if(m - cur >= 0) {
                    map.put(count, cur);
                    m -= cur;

                    break;
                }
            }
            if(cur == 0 && check(count ,n)){

            }
                count++;
        }
    }

    private static boolean check(int num, int n){
        return num % n != 0;
    }
}
