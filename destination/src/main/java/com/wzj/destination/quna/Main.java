package com.wzj.destination.quna;

import java.util.Scanner;

public class Main {
    static String[] preorder;
    static String[] inorder;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String[] array = str.split(",");
        int n = array.length;
        preorder = new String[n];
        for(int i = 0; i < n; i++){
            preorder[i] = array[i];
        }

        str = in.nextLine();
        array = str.split(",");
        inorder = new String[n];
        for(int i = 0; i < n; i++){
            inorder[i] = array[i];
        }

        postOrder(0, n - 1, 0, n - 1);
        System.out.println();

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
            if (inorder[index].equals(preorder[startP])) break;
        }
        postOrder(startP + 1, startP + i, startI, startI + i - 1);
        postOrder(startP +i + 1, endP, startI + i + 1, endI);
        System.out.print(preorder[startP] +" ");
    }
}
