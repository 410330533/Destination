package com.wzj.destination.others;

/**
 * Created by WZJ on 2018/5/31.
 */

public class ShortestPalindrome {
    public String getShortestPalindrome(String str){
        String rev = (new StringBuilder(str)).reverse().toString();
        int[] lps = getLPS(str + '#' + rev); //加#是为了处理空字符
        int remove = lps[lps.length - 1]; //找到整个字符串的最长前后缀，即lps数组中的最后一位
        return rev.substring(0, rev.length() - remove) + str; //rev从最后一位开始中去除remove长度的字符，将剩余字符插入到str的左侧
    }


    //KMP算法中求最长前后缀表，非next表   已知lps[0...j]，能够推出lps[j+1]，最终递推出整个lps数组
    public int[] getLPS(String str){
        int[] lps = new int[str.length()];
        int p = 0, s = 1; //p为前缀指针，s为后缀指针
        lps[0] = 0;
        while (s < str.length()){

            if (str.charAt(p) == str.charAt(s)){
                lps[s] = p + 1;
                p++;
                s++;
            }else {
                if(p != 0){
                    p = lps[p - 1]; //继续递归前缀索引（只能更改前缀索引，后缀索引是只能递增的，直到到达边界。且递归前缀与递归后缀的效果是一样的）
                }else {
                    lps[s] = 0;  //前缀索引归0
                    s++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {

        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        System.out.println(shortestPalindrome.getShortestPalindrome("abcd"));
    }
}
