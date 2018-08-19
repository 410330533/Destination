package com.wzj.destination.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MCSTree {
    public static void prim(int[][] graph){
        int min;
        int[] adjvex = new int[graph.length];  //保存相关顶点下标,adjex[0] = 1含义为最小生成树中存在从v1到v0的边
        int[] lowcost = new int[graph.length];  //保存相关顶点间的权重

        lowcost[0] = 0;
        adjvex[0] = 0;
        for (int i = 1; i < graph.length; i++){
            lowcost[i] = graph[0][i];    //初始化，将v0顶点与之有边的权值存入数组
            adjvex[i] = 0;         //初始化都为v0的下标
        }

        for (int i = 1; i < graph.length; i++){
            min = Integer.MAX_VALUE;
            int j = 1, k = 0;
            while (j < graph.length){
                if (lowcost[j] != 0 && lowcost[j] < min){
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }

            System.out.println(adjvex[k]+" "+k);
            lowcost[k] = 0; //表示vk已经被纳入最小生成树中，之后就不需要再访问了
            for (j = 1; j < graph.length; j++){
                if (lowcost[j] != 0 && graph[k][j] < lowcost[j]){
                    lowcost[j] = graph[k][j];
                    adjvex[j] = k;
                }
            }
        }

    }

    public static void kruskal(int[][] graph){
        ArrayList<Edge> edges = new ArrayList<>();

        int[] parent = new int[graph.length];
        //转化为边集数组，并按权由小到大排序
        for(int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[0].length; j++){
                if(graph[i][j] > 0 && graph[i][j] < Integer.MAX_VALUE){
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(edges, new MyComparator());

        for (int i = 0; i < edges.size(); i++){
            int n = check(parent, edges.get(i).begin);
            int m = check(parent, edges.get(i).end);
            if (n != m){
                parent[n] = m;
                System.out.println("("+ edges.get(i).begin+", "+edges.get(i).end+") "+edges.get(i).weight);
            }
        }

    }

    private static int check(int[] parent, int n){ //检测是否成环
        while (parent[n] > 0){
            n = parent[n];
        }
        return n;
    }
    private static class MyComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
    private static class Edge{
        int begin;
        int end;
        int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] graph = {{0,10,max,max,max,11,max,max,max},
                {10,0,18,max,max,max,16,max,12},
                {max,max,0,22,max,max,max,max,8},
                {max,max,22,0,20,max,max,16,21},
                {max,max,max,20,0,26,max,7,max},
                {11,max,max,max,26,0,17,max,max},
                {max,16,max,max,max,17,0,19,max},
                {max,max,max,16,7,max,19,0,max},
                {max,12,8,21,max,max,max,max,0}
        };
        //MCSTree.prim(graph);
        MCSTree.kruskal(graph);
    }
}
