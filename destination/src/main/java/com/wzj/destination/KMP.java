package com.wzj.destination; /**
 * Created by WZJ on 2018/8/5.
 */


import java.util.Arrays;

/**
 * Created by WZJ on 2018/6/2.
 */

//使用最大前后缀数组，非next数组

public class KMP {
    public int kmpSearch(String s, String p){
        int i = 0, j = 0;
        int[] lps = getLps(p);
        while (i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else {
                if (j != 0){
                    j = lps[j - 1]; //这里要用j-1，如果是next数组则是j
                }else {
                    i++;
                }

            }
        }
        if (j == p.length()){
            return i - j; //i - j为模式串在原字符串中的起始位置
        }else {
            return -1;
        }
    }

    public int[] getLps(String str){
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int p = 0, s = 1;
        while (s < str.length()){
            if (str.charAt(p) == str.charAt(s)){

                lps[s] = p + 1;

                p++;
                s++;
            }else {
                if (p != 0){
                    p = lps[p - 1];
                } else {
                    lps[p] = 0;
                    s++;
                }
            }
        }

        return lps;
    }


    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(Arrays.toString(kmp.getLps("abab")));
        //System.out.println(kmp.kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
