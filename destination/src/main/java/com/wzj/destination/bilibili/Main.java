package com.wzj.destination.bilibili;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = in.nextInt(), m = in.nextInt();
        int[][] graph = new int[n][n];
        in.nextLine();
        for(int i = 0; i < m; i++){
            String[] str = in.nextLine().split(",");
            int v = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            graph[v][k] = 1;
            graph[k][v] = 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(graph[a][i] == 1){
                set.add(i);
                graph[i][a] = 0;
                for(int j = 0; j < n; j++){
                    if(graph[i][j] == 1) set.add(j);
                }
                graph[i][a] = 1;
            }
        }
        System.out.println(set.size());
    }
}
