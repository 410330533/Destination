package com.wzj.destination.graph;

public class ShortestPath {
    public static void dijkstra(int[][] graph, int v){
        int[] path = new int[graph.length];    //当前节点的前一个节点，path[i] = j表示i的前一个节点为j
        int[] shortestPathTable = new int[graph.length];     //用于存储到各点最短路径的权值和
        int[] visited = new int[graph.length];

        //初始化
        for (int i = 0; i < graph.length; i++) {
            shortestPathTable[i] = graph[v][i];
            path[i] = v;
        }
        shortestPathTable[v] = 0;
        visited[v] = 1;

        //开始主循环，每次求得v到某个顶点的最短路径
        for(int i = 1; i < graph.length; i++){
            int min = Integer.MAX_VALUE;
            int k = v;
            for(int j = 0; j < graph.length; j++){
                if (visited[j] != 1 && shortestPathTable[j] < min){
                    k = j;
                    min = shortestPathTable[j];
                }
            }

            visited[k] = 1;   //将目前找到的最近的顶点置为1

            for(int j = 0; j < graph.length; j++){
                if (visited[j] != 1 && (graph[k][j] < shortestPathTable[j] - min)){ //防止溢出，等价于min + graph[k][j] < shortestPathTable[j]
                    shortestPathTable[j] = min + graph[k][j];
                    path[j] = k;
                }
            }
        }

        //输出结果
        for (int i = 0;i < graph.length; i++){
            System.out.print(path[i] +" ");
        }
        System.out.println();
        for (int i = 0;i < graph.length; i++){
            System.out.print(shortestPathTable[i] +" ");
        }
        System.out.println();
    }

    public static void floyd(int[][] graph, int[][] shortestPath, int[][] weight){
        //初始化
        for (int v = 0; v < graph.length; v++){
            for (int w = 0; w < graph.length; w++){
                weight[v][w] = graph[v][w];
                shortestPath[v][w] = w;
            }
        }

        //k为中转顶点的下标；v为起始顶点的下标；w为结束顶点的下标
        for (int k = 0; k < graph.length; k++){
            for (int v = 0; v < graph.length; v++){
                for (int w = 0; w < graph.length; w++){
                    if(weight[v][w] - weight[k][w] > weight[v][k]){
                        weight[v][w] = weight[v][k] + weight[k][w];
                        shortestPath[v][w] = shortestPath[v][k];
                    }
                }
            }
        }
    }

    private static void findPath(int[][] path, int i, int j){
        System.out.print(i + " ");
        while(i != j){
            i = path[i][j];
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] graph = {{0,1,5,max,max,max,max,max,max},
                {1,0,3,7,5,max,max,max,max},
                {5,3,0,max,1,7,max,max,max},
                {max,7,max,0,2,max,3,max,max},
                {max,5,1,2,0,3,6,9,max},
                {max,max,7,max,3,0,max,5,max},
                {max,max,max,3,6,max,0,2,7},
                {max,max,max,max,9,5,2,0,4},
                {max,max,max,max,max,max,7,4,0}};
        ShortestPath.dijkstra(graph, 0);
        int[][] path = new int[graph.length][graph.length];
        int[][] weight = new int[graph.length][graph.length];
        ShortestPath.floyd(graph, path, weight);
        findPath(path, 0, 8);
    }
}
