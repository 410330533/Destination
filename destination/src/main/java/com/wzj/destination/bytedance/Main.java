package com.wzj.destination.bytedance;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final String NO_ANSWER = "cannot_answer";
    public static void main(String[] args) {
        HashMap<String, Node> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        String[][] query = new String[m][2];
        in.nextLine();
        for(int i = 0; i < n; i++){
            String line = in.nextLine();
            String[] str = line.split("\\s");
            Node node = new Node(Integer.parseInt(str[2]), str[4]);
            map.put(str[0], node);
        }

        for(int i = 0; i < m; i++){
            String line = in.nextLine();
            String[] str = line.split("\\s");
            query[i][0] = str[0];
            query[i][1] = str[2];
        }

        //solve
        for(int i = 0; i < m; i++){
            if(map.containsKey(query[i][0])){
                int tmp = 0, flag = 1;
                Node node = map.get(query[i][0]);
                while (!node.symbol.equals(query[i][1])){
                    tmp += flag * node.val;
                    flag = flag * (-1);
                    node = map.get(node.symbol);
                    if(node == null){
                        System.out.println(NO_ANSWER);
                        break;
                    }
                }
                if (node == null) continue;
                tmp += flag * node.val;
                if(flag < 0){
                    System.out.println(tmp);
                    continue;
                }
            }
            if(map.containsKey(query[i][1])){
                int tmp = 0, flag = -1;
                Node node = map.get(query[i][1]);
                while (!node.symbol.equals(query[i][0])){
                    tmp += flag * node.val;
                    flag = flag * (-1);
                    node = map.get(node.symbol);
                    if(node == null){
                        System.out.println(NO_ANSWER);
                        break;
                    }
                }
                if (node == null) continue;
                tmp += flag * node.val;
                if(flag > 0){
                    System.out.println(tmp);
                    continue;
                }

            }
            System.out.println(NO_ANSWER);

        }


    }

    private static class Node{
        int val;
        String symbol;

        public Node(int val, String symbol) {
            this.val = val;
            this.symbol = symbol;
        }
    }
}
