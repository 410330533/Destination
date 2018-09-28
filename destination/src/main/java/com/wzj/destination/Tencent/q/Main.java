package com.wzj.destination.Tencent.q;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String a = in.nextLine(), b = in.nextLine();
        int m = a.length(), n = b.length();

        int res = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i + k <= m; i++){
            String sub = a.substring(i, i + k);
            if(!set.contains(sub)){
                set.add(sub);
                for(int j = 0; j + k <= n; j++){
                    int s = 0;
                    for(; s < k; s++){
                        if(sub.charAt(s) != b.charAt(j + s)){
                            break;
                        }
                    }
                    res += s == k ? 1 : 0;
                }
            }
        }
        System.out.println(res);
    }
}
