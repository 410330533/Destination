package com.wzj.destination.a360;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), c = in.nextInt();
        System.out.println(solve(x, c));
    }

    public static int solve(int x, int c){
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        while(true){
            int tmp = (1 << k) % c;
            if(set.contains(tmp)){
                break;
            }else{
                set.add(tmp);
                res++;
                k++;
            }
        }
        return res;
    }

}
