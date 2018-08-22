package com.wzj.destination.data_structure;

import java.util.Scanner;

/**
 * Created by WZJ on 2018/8/6.
 */


public class PreInPost1 {
    static class Node{
        public Node left;
        public Node right;
        public char val;

        public Node(char val) {
            this.val = val;
        }
    }
    static char[] preorder;
    static char[] inorder;
    static char[] tree;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            preorder = new char[n];
            inorder = new char[n];
            tree = new char[n];
            for(int i = 0; i < n; i++){
                preorder[i] = in.next().charAt(0);
            }
            for(int i = 0; i < n; i++){
                inorder[i] = in.next().charAt(0);
            }

            Node node = postOrder(0, n - 1, 0, n - 1);
            traverse(node);
            System.out.println();
        }
        in.close();
    }
    static Node postOrder(int startP, int endP, int startI, int endI){
        //System.out.println(startP+" "+ endP);
        if(startP > endP || startI > endI) return null;
        /*if(startI == endI) {
            System.out.print(inorder[startI] +" ");
            return;
        }*/

        Node node = new Node(preorder[startP]);
        int i = 0;
        for (int j = i + startI; j <= endI; j ++, i++) {
            if (inorder[j] == preorder[startP]) break;
        }
        node.left = postOrder(startP + 1, startP + i, startI, startI + i - 1);
        node.right = postOrder(startP +i + 1, endP, startI + i + 1, endI);
        return node;
        //System.out.print(preorder[startP] +" ");
    }
    public  static void traverse(Node node){
        if(node == null) return;
        traverse(node.left);
        traverse(node.right);
        System.out.print(node.val +" ");
    }
}
