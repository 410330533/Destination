package com.wzj.destination.kuaishou;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int result = 0;
        int low = 0;
        int high = n - 1;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int l_result = array[0];
        int h_result = array[n - 1];
        while (low < high) {
            if (l_result == h_result) {
                result = l_result;
                l_result += array[++low];
                h_result += array[--high];
            } else if (l_result < h_result) {
                l_result += array[++low];
            } else {
                h_result += array[--high];
            }
        }
        System.out.println(result);
    }

}
