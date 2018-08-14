package com.wzj.destination.others;

/**
 * Created by WZJ on 2018/6/3.
 */

public class Sunday {
    public int sundaySearch(String s, String p){
        int[] shift = new int[128];
        int m = s.length();
        int n = p.length();
        for (int i = 0; i < shift.length; i ++){
            shift[i] = -1;
        }
        for (int i = 0; i < n; i++){
            shift[p.charAt(i)] = n - i;     //求偏移数组，后面的字符会覆盖前面相同的字符
        }

        int i = 0, j;
        while (i < m - n){
            j = 0;   //一旦对齐后，j就置为0
            while (j < n){
                if (s.charAt(i) == p.charAt(j)){
                    i++;
                    j++;
                }else { //一旦不匹配，主字符串就向后跳
                    int index = i + n - j;          //主串与匹配串重合的部分的下一个字符位置
                    if (shift[s.charAt(index)] != -1){
                        i += shift[s.charAt(index)];    //主串中含有该字符，则使主串中的该字符与匹配串中该字符最后出现的位置对齐
                    }else {
                        i = index + 1;   //如果主串中没有这个字符，则直接跳过
                    }
                    break;
                }
            }
            if (j == n){
                return i - n;
            }

        }
        return -1;
    }

    int Sundays(String T, String P) {
        int n = T.length();
        int m = P.length();
        int[] shift = new int[128];
        // 默认值，移动m+1位
        for(int i = 0; i < 128; i++) {
            shift[i] = m + 1;
        }

        // 模式串P中每个字母出现的最后的下标
        // 所对应的主串参与匹配的最末位字符的下一位字符移动到该位，所需要的移动位数
        for(int i = 0; i < m; i++) {
            shift[P.charAt(i)] = m - i;
        }

        // 模式串开始位置在主串的哪里
        int s = 0;
        // 模式串已经匹配到的位置
        int j;
        while(s <= n - m) {
            j = 0;
            while(T.charAt(s + j) == P.charAt(j)) {
                j++;
                // 匹配成功
                if(j >= m) {
                    return s;
                }
            }
            // 找到主串中当前跟模式串匹配的最末字符的下一个字符
            // 在模式串中出现最后的位置
            // 所需要从(模式串末尾+1)移动到该位置的步数
            s += shift[T.charAt(s + m)];
        }
        return -1;
    }




    public static void main(String[] args) {
        Sunday sunday = new Sunday();
        System.out.println(sunday.sundaySearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        System.out.println(sunday.Sundays("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
