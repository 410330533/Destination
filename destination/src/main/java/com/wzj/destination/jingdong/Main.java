package com.wzj.destination.jingdong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }

    public static int solve(String s, String t){
        int res = 0, m = s.length(), n = t.length();
        char[][] dp = new char[n][m];
        for(int i = 0; i < m; i++){
            dp[0][i] = t.charAt(0);
        }
        for(int i = 1; i < n; i++){
            char a = t.charAt(i);
            for(int j = i; j < m; j++){
                char b = s.charAt(j);
                for(int q = i - 1, p = j - 1; q >= 0 && p >= 0; q--, p--){
                    char tmp = s.charAt(p);
                    if(dp[q][p] == '0'){
                        dp[i][j] = '0';
                        break;
                    }else if(tmp == b){
                        dp[i][j] = dp[q][p] == a ? dp[q][p] : '0';
                        break;
                    }
                }
            }
        }
        for(int i = n - 1; i < m; i++){
            if(dp[n - 1][i] != '\u0000') res++;
        }
        return res;
    }
}
