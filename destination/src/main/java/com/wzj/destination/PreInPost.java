package com.wzj.destination;

import java.util.Scanner;

/**
 * Created by WZJ on 2018/8/6.
 */

public class PreInPost {
    static char[] preorder;
    static char[] inorder;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            preorder = new char[n];
            inorder = new char[n];
            for(int i = 0; i < n; i++){
                preorder[i] = in.next().charAt(0);
            }
            for(int i = 0; i < n; i++){
                inorder[i] = in.next().charAt(0);
            }

            postOrder(0, n - 1, 0, n - 1);
            System.out.println();
        }
        in.close();
    }
    static void postOrder(int startP, int endP, int startI, int endI){
        //System.out.println(startP+" "+ endP);
        if(startP > endP || startI > endI) return;
        if(startI == endI) {
            System.out.print(inorder[startI] +" ");
            return;
        }
        //char c = preorder[startP];
        int i = 0;
        for (int index = i + startI; index <= endI; index ++, i++) {
            if (inorder[index] == preorder[startP]) break;
        }
        postOrder(startP + 1, startP + i, startI, startI + i - 1);
        postOrder(startP +i + 1, endP, startI + i + 1, endI);
        System.out.print(preorder[startP] +" ");
    }


}
