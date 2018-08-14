package com.wzj.destination.others;

import java.util.Arrays;

/**
 * Created by WZJ on 2018/5/30.
 */

public class NativeKMP {

    int kmpSearch(String s, String p){
        int i = 0, j = 0;
        int[] next = getNext(p);
        while (i < s.length() && j < p.length()){
            if (j == -1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;

            }else {
                j = next[j];
            }
        }
        if (j == p.length())
            return i - j;
        else
            return -1;
    }

    int[] getNext(String p){
        int[] next = new int[p.length()]; //除当前字符外，最长长度的前缀后缀
        next[0] = -1;
        int k = -1, j = 0; //k为前缀、j为后缀
        while (j < p.length() - 1){
            if(k == -1 || p.charAt(k) == p.charAt(j)){
                k++;
                j++;

                if(p.charAt(j) != p.charAt(k))
                    next[j] = k; // next[j + 1] = next[j] + 1 = k + 1;
                else
                    next[j] = next[k]; //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]

            }else {
                k = next[k]; //寻找长度更短的相同前缀后缀
            }
        }
        return next;
    }

    public static void main(String[] args) {
        NativeKMP nativeKMP = new NativeKMP();
        System.out.println(Arrays.toString(nativeKMP.getNext("BBC ABCDAB ABCDABCDABDE")));
        //System.out.println(nativeKMP.kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
