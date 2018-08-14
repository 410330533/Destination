package com.wzj.destination.os;

public class Banker {
    private int pNum;
    private int rNum;
    private int[] available;
    private int[][] max;
    private int[][] allocation;
    private int[][] need;


    public Banker(int pNum, int rNum, int[] available, int[][] max, int[][] allocation) {
        this.pNum = pNum;
        this.rNum = rNum;
        this.available = available;
        this.max = max;
        this.allocation = allocation;
        need = new int[pNum][rNum];
        for(int i = 0; i < pNum; i++){
            for (int j = 0; j < rNum; j++){
                need[i][j] = max[i][j] - allocation[i][j];
            }

        }
    }
    public boolean process(int index, int[] requrst){
        return safetyCheck() && resourceRequest(index, requrst);

    }
    public boolean safetyCheck(){
        boolean[] finish = new boolean[pNum];
        int[] work = new int[rNum];
        System.arraycopy(available, 0, work, 0, rNum);
        int index = 0;
        while (index++ < pNum){
            for(int i = 0; i < pNum; i++){
                if(!finish[i] && check(i, work)){
                    System.out.println(i);
                    finish[i] = true;
                    for(int j = 0; j < rNum; j++){
                        work[j] += allocation[i][j];

                    }
                    //System.out.println(Arrays.toString(work));
                    break;
                }
            }
        }

        index = 0;
        while(index < pNum && finish[index]){
            index++;
        }
        return index == pNum;
    }

    private boolean check(int index, int[] work){

        for(int i = 0; i < rNum; i++){
            if(need[index][i] > work[i]){
                return false;
            }
        }
        return true;
    }

    public boolean resourceRequest(int index, int[] request){
        for (int i = 0; i < rNum; i++){
            if(request[i] > need[index][i]){
                return false;
            }
        }

        for (int i = 0; i < rNum; i++){
            if(request[i] > available[i]){
                return false;
            }
        }

        for (int i = 0; i < rNum; i++){
            available[i] -= request[i];
            allocation[index][i] += request[i];
            need[index][i] -= request[i];
        }

        return safetyCheck();

    }
    public static void main(String[] args) {
        int pNum = 5, rNum = 3;
        int[][] allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[] available = {3, 3, 2};
        int index = 1;
        int[] request = {1, 0, 2};

        Banker banker = new Banker(pNum, rNum, available, max, allocation);
        System.out.println(banker.process(index, request));
    }
}
