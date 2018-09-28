package com.wzj.destination.kuaishou;

import java.util.Scanner;

public class Main {
    private static class Node{
        Node left;
        Node right;
        String val;
        int sum;

        Node(String val) {
            this.val = val;
        }
    }
    private static String[] preorder;
    private static String[] inorder;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String[] array = str.split("\\s");
        int n = array.length;
        preorder = new String[n];
        for(int i = 0; i < n; i++){
            preorder[i] = array[i];
        }

        str = in.nextLine();
        array = str.split("\\s");
        inorder = new String[n];
        for(int i = 0; i < n; i++){
            inorder[i] = array[i];
        }

        Node root = postOrder(0, n - 1, 0, n - 1);
        getSum(root);
        output(root);
    }

    static Node postOrder(int startP, int endP, int startI, int endI){

        if(startP > endP || startI > endI) return null;


        Node node = new Node(preorder[startP]);
        int i = 0;
        for (int j = i + startI; j <= endI; j ++, i++) {
            if (inorder[j].equals(preorder[startP])) break;
        }
        node.left = postOrder(startP + 1, startP + i, startI, startI + i - 1);
        node.right = postOrder(startP +i + 1, endP, startI + i + 1, endI);
        return node;

    }
    static int getSum(Node root){
        if(root == null) return 0;
        root.sum = getSum(root.left) + getSum(root.right);
        return Integer.parseInt(root.val) + root.sum;
    }
    static void output(Node root){
        if(root == null) return;
        output(root.left);
        System.out.print(root.sum+" ");
        output(root.right);
    }
}
