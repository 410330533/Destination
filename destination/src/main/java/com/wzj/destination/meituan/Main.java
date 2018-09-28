package com.wzj.destination.meituan;

import java.util.Scanner;

public class Main {
    static Node maxNode;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i + 1);
        }
        for(int i = 0; i < n - 1; i++){
            int cur = in.nextInt();
            int next = in.nextInt();
            Node tmp = nodes[cur - 1].next;
            Node nextNode = new Node(next);
            nodes[cur - 1].next = nextNode;
            nextNode.next = tmp;

            Node nextTmp = nodes[next - 1].next;
            Node newNode = new Node(cur);
            nodes[next - 1].next = newNode;
            newNode.next = nextTmp;
            //nodes[next - 1].next = nodes[cur - 1];
        }
        int t1 = dfs(nodes, 0, new boolean[n]);
        Node pre = maxNode, cur = maxNode.next;
        while(cur != null){
            if(cur.val == 1){
                Node next = cur.next;
                cur.next = null;
                pre.next = next;
            }
            pre = pre.next;
            cur = cur.next;
        }
        int t2 = dfs2(nodes, maxNode.val - 1, new boolean[n]) + 1;
        System.out.println((t1 - max) * 2 + t2);
    }

    public static int dfs(Node[] nodes, int index, boolean[] visited){
        //System.out.println(index);
        if(visited[index]) return 0;

        Node cur = nodes[index];
        visited[cur.val - 1] = true;
        int res = 0;
        while(cur.next != null && !visited[cur.next.val - 1]){
            int tmp = dfs(nodes, cur.next.val - 1, visited) + 1;

            if(tmp > max){
                max = tmp;
                maxNode = nodes[cur.next.val - 1];
            }
            res += tmp;

            cur = cur.next;
        }
        return res;
    }
    public static int dfs2(Node[] nodes, int index, boolean[] visited){
        //System.out.println(index);
        if(visited[index]) return 0;
        Node cur = nodes[index];
        visited[cur.val - 1] = true;
        int res = 0;
        while (cur.next != null && !visited[cur.next.val - 1]){
            int tmp = dfs2(nodes, cur.next.val - 1, visited) + 1;
            cur = cur.next;
            if(cur.next != null){
                tmp = tmp << 1;
            }
            res += tmp;
        }
        return res;
    }
    private static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
