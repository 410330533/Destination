package com.wzj.destination.others;

import java.util.Arrays;

/**
 * Created by WZJ on 2018/6/1.
 */

public class Test {

    public String getShortest(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        String rev = (new StringBuilder(str)).reverse().toString();
        stringBuilder.append(str).append('#').append(rev);
        String result = stringBuilder.toString();
        int[] lps = getLps(result);
        int remove = lps[lps.length - 1];
        return rev.substring(0, rev.length() - remove) + str;
    }

    public int[] getLps(String str){
        int[] lps = new int[str.length()];
        int p = 0, s = 1;
        lps[0] = 0;
        while (s < str.length()){
            if (str.charAt(p) == str.charAt(s)){
                lps[s] = p + 1;
                s++;
                p++;
            } else {
                if (p != 0){
                    p = lps[p - 1];
                } else {
                    lps[s] = 0;
                    s++;
                }
            }
        }
        return lps;
    }

    public boolean isMatch(String s, String p) {
        if(s == null && p == null){
            return true;
        }else if(s == null || p == null){
            return false;
        }

        if(s.isEmpty() && p.isEmpty()){
            return true;
        }
        if(p.length() == 1 && p.charAt(0) == '*'){
            return true;
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*'){
                if(count == 0){
                    builder.append("*");
                    count++;
                }else{
                    count++;
                }
            }else{
                count = 0;
                builder.append(p.charAt(i));
            }
        }
        System.out.println(builder.toString());
        return match(s, 0, builder.toString(), 0);


    }

    public boolean match(String s, int i, String p, int j){

        if(j == p.length()){
            if(i == s.length()){
                return true;
            }else{
                return false;
            }
        }

        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
            return match(s, i + 1, p, j + 1);
        }

        if(p.charAt(j) == '*'){
            if(j + 1 < p.length()){
                if(match(s, i, p, j + 1)){
                    return true;
                }else if(i + 1 < s.length()){
                    return match(s, i + 1, p, j);
                }else{
                    return false;
                }
            }else{
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getShortest("abcd"));
        System.out.println(Arrays.toString(test.getLps("agctagcagctagctg")));
        String s = "00000000000000000000000000000000000";
        System.out.println(Integer.parseInt(s));

        System.out.println(test.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb","**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}
