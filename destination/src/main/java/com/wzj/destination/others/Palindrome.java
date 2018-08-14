package com.wzj.destination.others;

/**
 * Created by WZJ on 2018/5/27.
 */

public class Palindrome {
    public String longestPalindrome(String s) {
        //预处理 加入"#"
        StringBuilder s1 = new StringBuilder();
        s1.append("&#");
        for(int i = 0; i < s.length(); i++){
            s1.append(s.charAt(i));
            s1.append('#');
        }
        //前后字符不同，可以省略边界处理操作
        s1.append('*');
        String ss = s1.toString();
        int[] p = new int[ss.length()];
        int id = 2, mx = 2, returnId = 2, returnMx = 2;

        for(int i = 2; i < ss.length() - 2; i++){

            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while(ss.charAt(i - p[i]) == ss.charAt(i + p[i])) p[i]++;
            if(mx < p[i] + i - 1){
                mx = p[i] + i - 1;
                id = i;
            }
            if(returnMx < p[i]){
                returnMx = p[i];
                returnId = i;
            }
        }
        //subSting(beginIndex, endIndex) 从beginIndex开始，到endIndex - 1结束，长度为endIndex - beginIndex
        return s.substring((returnId - returnMx)/2, (returnId - returnMx)/2 + returnMx - 1);

    }



    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.longestPalindrome("aacecaaa"));
        //System.out.println(palindrome.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
